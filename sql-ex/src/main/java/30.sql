select i.point, i.date, sumOut, sumInc from
(select point, date, sum(inc) as sumInc from income group by point, date) as i
left join
(select point, date, sum(out) as sumOut from outcome group by point, date) as o
on i.point=o.point and i.date=o.date
UNION
select o.point, o.date, sumOut, sumInc from
(select point, date, sum(inc) as sumInc from income group by point, date) as i
right join
(select point, date, sum(out) as sumOut from outcome group by point, date) as o
on i.point=o.point and i.date=o.date
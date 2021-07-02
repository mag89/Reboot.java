select i.point, i.date, i.inc, o.out  from income_o as i
left join outcome_o as o on i.point=o.point and i.date=o.date
union
select o.point, o.date, i.inc, o.out  from income_o as i
right join outcome_o as o on i.point=o.point and i.date=o.date

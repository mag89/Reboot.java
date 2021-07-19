select c from
(select name as n, cl.class as c from ships join classes as cl
on cl.class=ships.class
union all
select distinct ship as n, ship as c from outcomes where ship in
(select class from classes) and ship not in (select name from ships)
) as sidb group by c having count(c)=1
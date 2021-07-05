select country, cast(avg(mv) as numeric(6,2)) from
(select country, bore*bore*bore/2 as mv from
(select distinct(ship) from outcomes where ship in (select class from classes)and ship not in (select name from ships)) as o
join classes on o.ship=classes.class
union all
select country, bore*bore*bore/2 as mv from classes
join ships on classes.class=ships.class) as a group by country

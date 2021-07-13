select ship from outcomes where ship in (select class from classes)
union
select name from ships where name=class
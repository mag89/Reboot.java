with mp_union as
(
select model, price from PC
union all
select model, price from Laptop
union all
select model, price from Printer
)
select distinct model from mp_union where price=(select max(price) from mp_union);
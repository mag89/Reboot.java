select avg(price) from Product p join
(select model, price from PC
union all
select model, price from Laptop) as allMP
ON p.model=allMP.model
where p.maker='A';
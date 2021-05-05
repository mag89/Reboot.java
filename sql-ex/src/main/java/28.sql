select count(maker) from
(select maker, count(model) as mo from Product group by maker
having count(model)=1) as t;
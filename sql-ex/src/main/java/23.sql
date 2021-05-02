select makersPc.maker from (select * from Product where type='PC') as makersPc
join PC as pc ON makersPc.model=pc.model where pc.speed >= 750
intersect
select makersL.maker from (select * from Product where type='Laptop') as makersL
join Laptop as l ON l.model=makersL.model where l.speed>=750;
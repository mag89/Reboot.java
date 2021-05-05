select maker, avg(hd) from PC join
(select pcMakers.maker, pcMakers.model from
(select * from Product where type='PC') pcMakers
cross join
(select * from Product where type='Printer') as printMakers
where pcMakers.maker=printMakers.maker) as printersAndPcsMakers
ON PC.model=printersAndPcsMakers.model
group by maker;
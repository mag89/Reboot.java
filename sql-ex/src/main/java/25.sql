select distinct maker from
(select p1.maker maker, p2.model pcModel
from (select maker, type, model from Product where type='Printer') as p1
cross join (select maker, type, model from Product where type='PC') as p2
where p1.maker=p2.maker) as printersAndPcsMakers
join
(select model from PC where ram=(select min(ram) from PC)
AND speed=(select max(speed) from PC where ram=(select min(ram) from PC))) as minRamPcs
ON printersAndPcsMakers.pcModel=minRamPcs.model;
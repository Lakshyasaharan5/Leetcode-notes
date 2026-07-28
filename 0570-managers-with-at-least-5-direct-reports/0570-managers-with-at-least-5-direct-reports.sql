# Write your MySQL query statement below
-- emp id, manager id
-- 1   3      
-- 2   3   
-- 3   0   1   3  
-- 3   0   2   3  
-- 4   9

select a.name
from Employee a
join Employee b on a.id = b.managerId
group by a.id
having count(b.id) >= 5;
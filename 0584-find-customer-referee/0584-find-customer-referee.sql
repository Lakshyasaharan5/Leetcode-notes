# Write your MySQL query statement below
select name
from Customer
where (referee_id IS NOT NULL and referee_id != 2) or referee_id IS NULL;
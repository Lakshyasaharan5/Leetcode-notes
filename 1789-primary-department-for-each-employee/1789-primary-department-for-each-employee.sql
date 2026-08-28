# Write your MySQL query statement below
-- function over() (
--     partition by column
--     order by column asc/desc
-- )


with temp as (select *, count(*) over(
    partition by employee_id
) as total_depts
from Employee)
select employee_id, department_id
from temp
where primary_flag = 'Y' or total_depts = 1;
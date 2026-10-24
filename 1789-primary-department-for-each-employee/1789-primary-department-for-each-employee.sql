# Write your MySQL query statement below
-- +-------------+---------------+--------------+
-- | employee_id | department_id | primary_flag | window func count
-- +-------------+---------------+--------------+
-- | 1           | 1             | N            | 1
-- | 2           | 1             | Y            | 2
-- | 2           | 2             | N            | 2
-- | 3           | 3             | N            | 1
-- | 4           | 2             | N            | 3
-- | 4           | 3             | Y            | 3
-- | 4           | 4             | N            | 3
-- +-------------+---------------+--------------+

with temp as (
    select *, count(*) over (
        partition by employee_id
    ) as total_depts
    from Employee
),
temp2 as (
select distinct employee_id, 
    case
        when total_depts = 1 or (total_depts != 1 and primary_flag = 'Y') then department_id
    end as department_id
from temp)
select * from temp2 where department_id is not null;
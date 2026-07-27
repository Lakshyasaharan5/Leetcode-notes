# Write your MySQL query statement below
-- 1 alice *math   
-- 1 alice *math   
-- 1 alice *math   
-- 1 alice *physics      
-- 1 alice *physics  
-- 1 alice *programming
-- 6 alex  math         null
-- 6 alex  physics      null
-- 6 alex  programming  null

with ss as (
    select *
    from Students st
    join Subjects sub
)
select ss.student_id, ss.student_name, ss.subject_name, count(e.subject_name) as attended_exams
from ss
left join Examinations e on ss.student_id = e.student_id and ss.subject_name = e.subject_name
group by ss.subject_name, ss.student_id
order by ss.student_id, ss.subject_name;
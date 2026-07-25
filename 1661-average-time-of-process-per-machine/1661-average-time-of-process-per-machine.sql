# Write your MySQL query statement below
 select a.machine_id, ROUND(AVG(b.timestamp - a.timestamp),3) as processing_time
    from Activity a
    join Activity b on (a.machine_id = b.machine_id and a.process_id = b.process_id)
    where a.activity_type = 'start' and b.activity_type = 'end'      
    group by a.machine_id
-- 0 0 1
-- 0 1 2
-- 0 2 9
-- 1 0 3
-- 1 1 4
-- 1 2 6

-- 0 3 12
-- 1 3 13
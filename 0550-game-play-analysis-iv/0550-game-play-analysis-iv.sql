# Write your MySQL query statement below
-- function() over (
--     parition by column 
--     order by column desc
-- )

with ranked as (select player_id, event_date, 
RANK() over (
    partition by player_id
    order by event_date asc
) as rn
from Activity)
select coalesce(round(sum(case when DATEDIFF(r2.event_date, r1.event_date) = 1 then 1 else 0 end)/(select count(distinct player_id) from Activity),2),0) as fraction
from ranked r1
join ranked r2 on r1.rn = 1 and r2.rn = 2 and r1.player_id = r2.player_id;


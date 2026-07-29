# Write your MySQL query statement below
with total_req as (
    select s.user_id, count(c.action) as requests
    from Signups s
    left join Confirmations c on s.user_id = c.user_id
    group by s.user_id
),
total_conf as (
    select s.user_id, count(c.action) as conf
    from Signups s
    left join Confirmations c on s.user_id = c.user_id and c.action = 'confirmed'
    group by s.user_id
)
select tr.user_id, 
    case 
        when tr.requests > 0 then round(tc.conf/tr.requests,2)
        else 0
    end as confirmation_rate
from total_req tr
join total_conf tc on tr.user_id = tc.user_id;


-- 3 ~
-- 7 c
-- 7 c
-- 7 c
-- 2 c
-- 6 ~

-- total
-- 3 2
-- 7 3
-- 2 2
-- 6 0

-- confirmed
-- 3 0
-- 7 3
-- 2 1
-- 6 0
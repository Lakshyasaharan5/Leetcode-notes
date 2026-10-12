# Write your MySQL query statement below

-- select user_id, count(user_id)
-- from Confirmations c
-- group by user_id;

with req_count_table as (
    select user_id,
        sum(case
            when action='timeout' then 0
            when action='confirmed' then 1
            else 0
        end) as conf_request,
        count(user_id) as total_request  
    from Confirmations c
    group by user_id
)
select s.user_id, coalesce(round((rt.conf_request/rt.total_request),2), 0) as confirmation_rate
from Signups s
left join req_count_table rt
on rt.user_id = s.user_id;

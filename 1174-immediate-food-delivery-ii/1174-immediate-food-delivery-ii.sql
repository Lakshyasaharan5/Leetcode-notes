# Write your MySQL query statement below
with ranked as (select *,
row_number() over (
    partition by customer_id
    order by order_date asc
) as rn
from Delivery)
select round((sum(case when order_date = customer_pref_delivery_date then 1 else 0 end)/count(*)) * 100, 2) as immediate_percentage
from ranked
where rn = 1;

-- function() over (partition by col order by col)
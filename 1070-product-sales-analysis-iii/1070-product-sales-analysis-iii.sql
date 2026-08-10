# Write your MySQL query statement below
-- function() over (
-- partition by
-- order by)
with ranked as (
select *, RANK() over (
    partition by product_id
    order by year asc
) as rn
from Sales
)
select product_id, year as first_year , quantity, price
from ranked
where rn = 1;
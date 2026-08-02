# Write your MySQL query statement below
with temp as (
    select p.product_id, 
    sum(case
        when p.price is not null and u.units is not null then (round(p.price * u.units, 2)) else 0        
    end) as total_price,
    sum(case
        when u.units is not null then (u.units) else 0
    end) as total_units
    from Prices p
    left join UnitsSold u
    on p.product_id = u.product_id 
    and p.start_date <= u.purchase_date
    and u.purchase_date <= p.end_date
    group by p.product_id
)
select product_id, 
    case
        when total_units <> 0 then round(total_price/total_units,2) else 0
    end as average_price
from temp;
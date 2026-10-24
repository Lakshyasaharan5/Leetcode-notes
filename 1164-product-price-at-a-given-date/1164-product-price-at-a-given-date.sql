# Write your MySQL query statement below

-- 2019-08-16
-- +------------+-----------+-------------+
-- | product_id | new_price | change_date |
-- +------------+-----------+-------------+
-- | 1          | 35        | 2019-08-16  |1

-- | 2          | 50        | 2019-08-14  |1
-- +------------+-----------+-------------+

-- remove dates greater then 2019-08-16
-- rank in ascending
-- keep only rn = 1
-- left join with product_id
-- coalesce null with 10
with p2 as 
(select *
    from (
        select *, 
            row_number() over (
                partition by product_id
                order by change_date desc
            ) as ranked_date
        from Products
        where change_date <= '2019-08-16'
    ) as temp 
where temp.ranked_date=1)
select distinct p1.product_id, coalesce(p2.new_price, 10) as price
from Products p1
left join p2
on p1.product_id = p2.product_id;

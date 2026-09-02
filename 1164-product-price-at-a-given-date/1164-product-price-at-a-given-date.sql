# Write your MySQL query statement below
with temp1 as (select *, 
    row_number() over (
        partition by product_id
        order by change_date desc
    ) as rn
from Products
where change_date <= "2019-08-16"
order by product_id asc),
temp2 as (
    select *, 
    row_number() over (
        partition by product_id
        order by change_date asc
    ) as rn
    from Products  
    where product_id not in (select product_id from temp1)  
),
temp3 as (
    select * from temp1
    where rn = 1
    union all 
    select * from temp2
    where rn = 1
)
select product_id,
    case 
        when change_date > '2019-08-16' then 10 else new_price
    end as price 
from temp3;

-- Input: 
-- Products table:
-- +------------+-----------+-------------+
-- | product_id | new_price | change_date |
-- +------------+-----------+-------------+
-- | 1          | 20        | 2019-08-14  | 1
-- | 1          | 30        | 2019-08-15  | 2
-- | 1          | 35        | 2019-08-16  | 3
-- | 1          | 30        | 2019-08-17  |

-- | 2          | 50        | 2019-08-14  | 1 
-- | 2          | 65        | 2019-08-17  |


-- | 3          | 20        | 2019-08-18  |
-- +------------+-----------+-------------+

-- for latest change_date <= 2019-08-16
--     exist:
--         whatever is the price
--     else:
--         10




-- Output: 
-- +------------+-------+
-- | product_id | price |
-- +------------+-------+
-- | 2          | 50    |
-- | 1          | 35    |
-- | 3          | 10    |
-- +------------+-------+
# Write your MySQL query statement below
-- +----+-----+
-- | id | num | id2 id3
-- +----+-----+
-- | 1  | 1   | 2  3
-- | 2  | 1   | 3  -
-- | 3  | 1   | -  -
-- | 4  | 2   | -  -
-- | 5  | 1   | -
-- | 6  | 2   | 7
-- | 7  | 2   | -
-- +----+-----+

-- id num  id1 num1
-- 1   1    -    -
-- 2   2    
-- 3   2
-- 4   2

-- id+1 = num

select distinct l1.num as ConsecutiveNums
from Logs l1
join Logs l2 on l1.num = l2.num and l1.id + 1 = l2.id
join Logs l3 on l2.num = l3.num and l2.id + 1 = l3.id;
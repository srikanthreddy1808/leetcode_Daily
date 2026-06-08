# Write your MySQL query statement below
SELECT email AS EMAIL
FROM PERSON
GROUP BY email
HAVING COUNT(*) > 1;
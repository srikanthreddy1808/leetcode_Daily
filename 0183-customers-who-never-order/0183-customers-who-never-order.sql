# Write your MySQL query statement below
SELECT c.name AS Customers
FROM CUSTOMERS  C
LEFT JOIN ORDERS  O
ON C.ID = O.customerid
WHERE O.CUSTOMERID IS NULL;
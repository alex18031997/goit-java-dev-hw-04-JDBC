SELECT c.name, p.MONTH_COUNT
FROM (
    SELECT p.CLIENT_ID, MAX(DATEDIFF(month, p.START_DATE, p.FINISH_DATE)) AS MONTH_COUNT
    FROM project p
    GROUP BY p.CLIENT_ID
    ORDER BY MONTH_COUNT DESC
    LIMIT 1
) AS p
JOIN CLIENT c ON p.CLIENT_ID = c.ID;
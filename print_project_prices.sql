SELECT
    C.name AS NAME,
    (DATEDIFF(month, P.START_DATE, P.FINISH_DATE) * W.SALARY) AS PRICE
FROM
    project_worker PW
JOIN
    worker W ON PW.WORKER_ID = W.ID
JOIN
    project P ON PW.PROJECT_ID = P.ID
JOIN
    client C ON P.CLIENT_ID = C.id;
-- 대여 시작일을 기준으로 2022년 8월부터 2022년 10월까지 총 대여 횟수가 5회 이상인 자동차
-- 월을 기준으로 오름차순 정렬하고, 월이 같다면 자동차 ID를 기준으로 내림차순 정렬
SELECT MONTH(start_date) AS month,
       car_id,
       COUNT(*) AS records
  FROM car_rental_company_rental_history
 WHERE start_date BETWEEN ('2022-08-01 00:00:00') AND ('2022-10-31 23:59:59')
   AND car_id IN (SELECT car_id
                    FROM car_rental_company_rental_history
                   WHERE start_date BETWEEN ('2022-08-01 00:00:00') AND ('2022-10-31 23:59:59')
                   GROUP BY car_id
                  HAVING COUNT(car_id) >= 5)
 GROUP BY MONTH(start_date), car_id
HAVING COUNT(*) > 0
 ORDER BY month, car_id DESC;
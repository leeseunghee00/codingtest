-- 2022년 10월 16일에 대여 중인 자동차인 경우 '대여중' 이라고 표시하고, 대여 중이지 않은 자동차인 경우 '대여 가능'을 표시
-- 자동차 ID를 기준으로 내림차순 정렬
SELECT car_id,
       CASE WHEN 
                 MIN(start_date) <= '2022-10-16 23:59:59' AND
                 MAX(end_date) >= '2022-10-16 00:00:00'
            THEN '대여중' 
            ELSE '대여 가능'
        END AS availability
  FROM car_rental_company_rental_history
 WHERE start_date <= '2022-10-16 23:59:59'
 GROUP BY car_id
 ORDER BY car_id DESC;
        
        
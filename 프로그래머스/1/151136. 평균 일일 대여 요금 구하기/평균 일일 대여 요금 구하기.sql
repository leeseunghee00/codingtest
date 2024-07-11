-- 출력: SUV 차의 평균 일일 대여 요금(average_fee)
-- 조건: 평균 일일 대여 요금의 소수 첫번째 자리 반올림

SELECT ROUND(AVG(daily_fee)) AS 'average_fee'
  FROM car_rental_company_car
 WHERE car_type = 'SUV';
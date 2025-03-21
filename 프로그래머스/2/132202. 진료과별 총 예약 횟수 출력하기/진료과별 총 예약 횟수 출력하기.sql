-- 2022년 5월에 예약한 환자 수를 진료과코드 별로 조회
-- 진료과별 예약한 환자 수를 기준으로 오름차순 정렬하고, 예약한 환자 수가 같다면 진료과 코드를 기준으로 오름차순 정렬
SELECT mcdp_cd AS '진료과코드', COUNT(*) AS '5월예약건수'
  FROM appointment
 WHERE DATE_FORMAT(apnt_ymd, '%Y-%m') = '2022-05'
 GROUP BY mcdp_cd
 ORDER BY 5월예약건수, 진료과코드;
-- 2021년에 가입한 회원 중 나이가 20세 이상 29세 이하인 회원이 몇 명인지 출력
SELECT COUNT(*) AS 'USERS'
  FROM user_info
 WHERE joined BETWEEN ('2021-01-01') AND ('2021-12-31') 
   AND age BETWEEN (20) AND (29);
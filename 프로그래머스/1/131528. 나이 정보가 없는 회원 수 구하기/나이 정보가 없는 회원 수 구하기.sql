-- 나이 정보가 없는 회원이 몇 명인지 출력
SELECT COUNT(*) AS 'users'
  FROM user_info
 WHERE age IS NULL;
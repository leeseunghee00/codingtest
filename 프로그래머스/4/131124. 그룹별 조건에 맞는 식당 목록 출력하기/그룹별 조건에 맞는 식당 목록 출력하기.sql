-- 출력: 회원이름, 리뷰텍스트, 리뷰작성일
-- 조건: 리뷰를 가장 많이 작성한 회원의 리뷰 조회
-- 정렬: 리뷰작성일 기준 오름차순, 리뷰텍스트 기준 오름차순

WITH max_reviewer AS (
    SELECT member_id
      FROM rest_review
     GROUP BY member_id
     ORDER BY COUNT(*) DESC
     LIMIT 1
) 

SELECT m.member_name, r.review_text, 
       date_format(r.review_date, '%Y-%m-%d') AS 'review_date'
  FROM rest_review r
  JOIN member_profile m 
    ON r.member_id = m.member_id
 WHERE r.member_id = (SELECT member_id FROM max_reviewer)
 ORDER BY r.review_date ASC, r.review_text ASC;
-- 출력: 식당ID, 식당이름, 음식종류, 즐겨찾기수, 주소, 리뷰평균점수
-- 조건: 서울에 위치한 식당 조회
-- 정렬: 평균점수 기준 내림차순, 즐겨찾기수 기준 내림차순

SELECT ri.rest_id, ri.rest_name, 
       ri.food_type, ri.favorites, ri.address, 
       ROUND(AVG(rr.review_score), 2) AS 'score'
  FROM rest_info ri
  JOIN rest_review  rr
    ON ri.rest_id = rr.rest_id
 WHERE ri.address LIKE '서울%'
 GROUP BY ri.rest_id
 ORDER BY score DESC, ri.favorites DESC;
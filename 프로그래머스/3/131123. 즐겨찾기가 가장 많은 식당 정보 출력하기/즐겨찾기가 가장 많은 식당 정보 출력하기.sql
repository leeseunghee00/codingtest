-- 음식종류별로 즐겨찾기수가 가장 많은 식당의 음식 종류, ID, 식당 이름, 즐겨찾기수를 조회
-- 음식 종류를 기준으로 내림차순 정렬
SELECT r1.food_type AS 'food_type',
       r1.rest_id AS 'rest_id',
       r1.rest_name AS 'rest_name',
       r1.favorites
  FROM rest_info r1
  JOIN (SELECT food_type, MAX(favorites) AS 'favorites'
          FROM rest_info
         GROUP BY food_type) r2 
    ON r1.food_type = r2.food_type AND r1.favorites = r2.favorites
 ORDER BY r1.food_type DESC;
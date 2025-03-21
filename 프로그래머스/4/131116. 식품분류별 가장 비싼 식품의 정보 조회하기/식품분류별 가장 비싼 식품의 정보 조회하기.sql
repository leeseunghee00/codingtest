-- 식품분류별로 가격이 제일 비싼 식품의 분류, 가격, 이름을 조회
-- 식품분류가 '과자', '국', '김치', '식용유'인 경우만 출력
-- 식품 가격을 기준으로 내림차순 정렬
SELECT f1.category AS 'category',
       f1.price AS 'max_price',
       f1.product_name AS 'product_name'
  FROM food_product f1
  JOIN (SELECT category, MAX(price) AS 'price'
          FROM food_product
         GROUP BY category
       ) f2
    ON f1.category = f2.category AND f1.price = f2.price
 WHERE f1.category IN ('과자', '국', '김치', '식용유')
 GROUP BY f1.category
 ORDER BY max_price DESC;
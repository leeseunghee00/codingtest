-- 출력: 상품코드별 매출액(판매가 * 판매량) 합계
-- 정렬: 매출액 기준 내림차순, 상품코드 기준 오름차순

SELECT p.product_code, (p.price * SUM(os.sales_amount)) AS 'sales'
  FROM product p
  JOIN offline_sale os
    ON p.product_id = os.product_id
 GROUP BY p.product_code
 ORDER BY (p.price * SUM(os.sales_amount)) DESC, p.product_code ASC; 
 
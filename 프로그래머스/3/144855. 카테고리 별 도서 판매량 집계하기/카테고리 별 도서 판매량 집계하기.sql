-- 2022년 1월의 카테고리 별 도서 판매량을 합산하고, 카테고리(CATEGORY), 총 판매량(TOTAL_SALES) 리스트를 출력
-- 카테고리명을 기준으로 오름차순 정렬
SELECT b.category AS 'category', SUM(bs.sales) AS 'total_sales'
  FROM book b
  LEFT JOIN book_sales bs ON b.book_id = bs.book_id
 WHERE DATE_FORMAT(bs.sales_date, '%Y-%m') = '2022-01'
 GROUP BY b.category
 ORDER BY category;
-- 출력: 아이스크림 성분 타입, 총주문량(total_order)
-- 조건: 총주문량 기준 오름차순

SELECT ii.ingredient_type, SUM(fh.total_order) AS 'total_order'
  FROM icecream_info ii
  JOIN first_half fh
    ON ii.flavor = fh.flavor
 GROUP BY ii.ingredient_type
 ORDER BY total_order ASC;

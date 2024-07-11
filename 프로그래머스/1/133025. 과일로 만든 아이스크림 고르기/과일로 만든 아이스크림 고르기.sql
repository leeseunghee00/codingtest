-- 출력: 총주문량이 3000 이상이고 주 성분이 과일인 아이스크림
-- 정렬: 총주문량 기준 내림차순

SELECT DISTINCT flavor
  FROM first_half
 WHERE total_order >= 3000
   AND flavor IN (SELECT flavor 
                   FROM icecream_info 
                  WHERE ingredient_type = 'fruit_based')
 ORDER BY total_order DESC;  
  
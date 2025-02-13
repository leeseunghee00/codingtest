-- 희귀도가 'LEGEND'인 아이템들의 가격의 총합
SELECT SUM(price) AS 'total_price'
  FROM item_info
 WHERE rarity = 'legend';
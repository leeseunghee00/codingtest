-- 아이템 ID(ITEM_ID), 아이템 명(ITEM_NAME), 아이템의 희귀도(RARITY)를 출력
-- 아이템 ID를 기준으로 내림차순 정렬
SELECT A.item_id AS item_id, A.item_name AS item_name, A.rarity AS rarity
  FROM item_info A
  LEFT OUTER JOIN item_tree B ON A.item_id = B.item_id
 WHERE B.parent_item_id IN (SELECT item_id
                              FROM item_info
                             WHERE rarity = 'RARE')
 ORDER BY item_id DESC;
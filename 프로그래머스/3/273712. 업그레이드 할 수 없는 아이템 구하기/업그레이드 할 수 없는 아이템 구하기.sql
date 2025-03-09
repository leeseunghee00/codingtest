-- 더 이상 업그레이드할 수 없는 아이템의 아이템 ID(ITEM_ID), 아이템 명(ITEM_NAME), 아이템의 희귀도(RARITY)를 출력
-- 아이템 ID를 기준으로 내림차순 정렬
SELECT A.item_id AS item_id, A.item_name AS item_name, A.rarity AS rarity
  FROM item_info A
  LEFT OUTER JOIN item_tree B ON A.item_id = B.item_id
 WHERE A.item_id NOT IN (SELECT DISTINCT parent_item_id
                           FROM item_tree
                          WHERE parent_item_id IS NOT NULL)
 ORDER BY item_id DESC;
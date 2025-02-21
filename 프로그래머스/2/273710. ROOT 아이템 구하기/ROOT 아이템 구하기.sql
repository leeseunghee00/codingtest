-- ROOT 아이템을 찾아 아이템 ID(ITEM_ID), 아이템 명(ITEM_NAME)을 출력
-- 아이템 ID를 기준으로 오름차순 정렬
SELECT tf.item_id AS 'item_id', tf.item_name AS 'item_name'
  FROM item_info tf
  JOIN item_tree tt ON tf.item_id = tt.item_id
 WHERE tt.parent_item_id IS NULL
 ORDER BY item_id;
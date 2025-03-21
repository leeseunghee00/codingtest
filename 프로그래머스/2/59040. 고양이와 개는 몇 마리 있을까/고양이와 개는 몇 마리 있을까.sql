-- 고양이와 개가 각각 몇 마리인지 조회
-- 고양이를 개보다 먼저 조회

SELECT animal_type, COUNT(*) AS 'count'
  FROM animal_ins
 GROUP BY animal_type
 ORDER BY FIELD (animal_type, 'Cat', 'Dog');
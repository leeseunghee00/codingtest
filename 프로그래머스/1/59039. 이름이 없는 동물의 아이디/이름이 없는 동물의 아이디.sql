-- 이름이 없는 채로 들어온 동물의 ID를 조회
-- ID는 오름차순 정렬
SELECT animal_id
  FROM animal_ins
 WHERE name IS NULL
 ORDER BY animal_id;
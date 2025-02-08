-- 동물 보호소에 가장 먼저 들어온 동물의 이름을 조회
SELECT name
  FROM animal_ins
 ORDER BY datetime
 LIMIT 1;
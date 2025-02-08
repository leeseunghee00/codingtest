# 모든 동물의 아이디와 이름, 보호 시작일을 이름 순
SELECT animal_id, name, datetime
  FROM animal_ins
 ORDER BY name ASC, datetime DESC;
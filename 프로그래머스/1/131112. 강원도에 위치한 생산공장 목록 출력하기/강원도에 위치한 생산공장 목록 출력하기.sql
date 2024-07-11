-- 출력: 공장ID, 공장이름, 주소
-- 조건: 강원도에 위치한 식품공장
-- 정렬: 공장ID 기준 오름차순

SELECT factory_id, factory_name, address
  FROM food_factory
 WHERE address LIKE '강원도%'
 ORDER BY factory_id ASC;
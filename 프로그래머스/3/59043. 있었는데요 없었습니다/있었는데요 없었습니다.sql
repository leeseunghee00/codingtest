-- 출력: 동물ID, 동물이름
-- 조건: 보호시작일보다 입양일이 더 빠른 동물 조회
-- 정렬: 보호 시작일 기준 오름차순
-- animal_ins: 동물 보호 정보
-- animal_outs: 입양 보낸 정보

SELECT ai.animal_id, ai.name
  FROM animal_ins ai
  JOIN animal_outs ao
    ON ai.animal_id = ao.animal_id
 WHERE ai.datetime > ao.datetime
 ORDER BY ai.datetime ASC;
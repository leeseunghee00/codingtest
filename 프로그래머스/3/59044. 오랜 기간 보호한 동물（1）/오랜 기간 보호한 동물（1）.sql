-- 출력: 이름, 보호시작일
-- 조건: 입양 못 간 동물 중 가장 오래 보호된 동물 3마리
-- 정렬: 보호 시작일 순

SELECT ai.name, ai.datetime
  FROM animal_ins ai
LEFT OUTER JOIN animal_outs ao
    ON ai.animal_id = ao.animal_id
 WHERE ao.datetime IS NULL
 ORDER BY ai.datetime ASC
 LIMIT 3;
  
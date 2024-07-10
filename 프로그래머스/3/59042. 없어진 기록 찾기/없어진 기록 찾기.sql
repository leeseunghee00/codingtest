-- 출력: 동물ID, 이름
-- 조건: 입양 기록은 있고, 보호 기록이 없는 동물 조회
-- 정렬: ID순
-- animal_ins: 보호 기록
-- animal_outs: 입양 기록

SELECT ao.animal_id, ao.name
  FROM animal_outs ao
LEFT OUTER JOIN animal_ins ai
    ON ao.animal_id = ai.animal_id
 WHERE ai.datetime IS NULL
 ORDER BY ao.animal_id ASC;
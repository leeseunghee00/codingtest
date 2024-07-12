-- 출력: 동물ID, 생물종, 이름
-- 조건: 중성화가 되어 나간 동물 조회
-- 정렬: 동물ID 순

SELECT ai.animal_id, ai.animal_type, ai.name
  FROM animal_ins ai 
  JOIN animal_outs ao
    ON ai.animal_id = ao.animal_id
 WHERE ai.sex_upon_intake LIKE 'Intact%' 
   AND (ao.sex_upon_outcome LIKE 'Spayed%'
    OR ao.sex_upon_outcome LIKE 'Neutered%')
 ORDER BY ai.animal_id ASC;
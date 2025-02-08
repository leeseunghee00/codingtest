-- 가장 큰 물고기 10마리의 ID와 길이를 출력
-- 길이를 기준으로 내림차순 정렬하고, 길이가 같다면 물고기의 ID에 대해 오름차순 정렬
SELECT id, length
  FROM fish_info
 ORDER BY length DESC, length DESC, id ASC
 LIMIT 10;


-- 잡은 물고기 중 길이가 10cm 이하인 물고기의 수를 출력
SELECT COUNT(*) AS fish_count
  FROM fish_info
 WHERE length IS NULL;
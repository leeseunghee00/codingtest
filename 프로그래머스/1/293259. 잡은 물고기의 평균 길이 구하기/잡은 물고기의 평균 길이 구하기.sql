-- 잡은 물고기의 평균 길이를 출력
SELECT ROUND(AVG(CASE WHEN length <= 10 OR length IS NULL
                      THEN 10
                      ELSE length
                  END), 2) AS average_length
  FROM fish_info;
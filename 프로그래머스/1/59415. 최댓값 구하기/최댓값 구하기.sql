-- 가장 최근에 들어온 동물은 언제 들어왔는지 조회
SELECT datetime AS '시간'
  FROM animal_ins
 ORDER BY datetime DESC
 LIMIT 1;
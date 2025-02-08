-- Python이나 C# 스킬을 가진 개발자의 정보를 조회
-- ID를 기준으로 오름차순 정렬
SELECT DISTINCT d.id AS id, d.email AS email, d.first_name AS first_name, d.last_name AS last_name
  FROM developers d
  JOIN skillcodes sc ON sc.code & d.skill_code
 WHERE sc.name IN ('Python', 'C#')
 ORDER BY id;
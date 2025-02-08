-- Python 스킬을 가진 개발자의 정보를 조회
-- ID를 기준으로 오름차순 정렬
SELECT id, email, first_name, last_name
  FROM developer_infos
 WHERE skill_1 = 'Python'
    OR skill_2 = 'Python'
    OR skill_3 = 'Python' 
 ORDER BY id;
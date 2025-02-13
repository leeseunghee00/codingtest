-- 물고기 종류 별로 가장 큰 물고기의 ID, 물고기 이름, 길이를 출력
SELECT fi.id AS 'id', fn.fish_name AS 'fish_name', fi.length AS 'length'
  FROM fish_info fi
  JOIN fish_name_info fn ON fn.fish_type = fi.fish_type
 WHERE fi.length = (SELECT MAX(f.length)
                      FROM fish_info f
                     WHERE f.fish_type = fi.fish_type)
 ORDER BY fi.id;
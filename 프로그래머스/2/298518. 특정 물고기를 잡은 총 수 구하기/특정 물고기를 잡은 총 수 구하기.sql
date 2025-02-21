-- 잡은 BASS와 SNAPPER의 수를 출력
SELECT COUNT(*) AS 'fish_count'
  FROM fish_info fi
 WHERE fi.fish_type = (SELECT fish_type FROM fish_name_info WHERE fish_name = 'SNAPPER')
    OR (fi.fish_type = (SELECT fish_type FROM fish_name_info WHERE fish_name = 'BASS'));
   
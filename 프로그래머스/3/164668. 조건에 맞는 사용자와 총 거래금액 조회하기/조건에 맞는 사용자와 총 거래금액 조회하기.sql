-- 완료된 중고 거래의 총금액이 70만 원 이상인 사람의 회원 ID, 닉네임, 총거래금액을 조회
-- 총거래금액을 기준으로 오름차순 정렬
SELECT ugu.user_id AS 'user_id',
       ugu.nickname AS 'nickname',
       SUM(ugb.price) AS 'total_sales'
  FROM used_goods_board ugb
  JOIN used_goods_user ugu ON ugb.writer_id = ugu.user_id
 WHERE ugb.status = 'DONE'
 GROUP BY ugb.writer_id
HAVING SUM(ugb.price) >= 700000
 ORDER BY total_sales;
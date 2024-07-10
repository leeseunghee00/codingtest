-- 출력: 도서ID, 저자명, 출판일
-- 조건: 경제 카테고리에 속한 도서들 조회
-- 정렬: 출판일 기준 오름차순

SELECT b.book_id, a.author_name, 
       date_format(b.published_date, '%Y-%m-%d') AS 'published_date'
  FROM book b
  JOIN author a
    ON b.author_id = a.author_id
 WHERE b.category = '경제'
 ORDER BY b.published_date ASC;
-- 분화된 연도(YEAR), 분화된 연도별 대장균 크기의 편차(YEAR_DEV), 대장균 개체의 ID(ID) 를 출력
-- 연도에 대해 오름차순으로 정렬, 대장균 크기의 편차에 대해 오름차순으로 정렬
SELECT YEAR(differentiation_date) AS year,
       (SELECT MAX(size_of_colony) 
          FROM ecoli_data
         WHERE year = YEAR(differentiation_date)
       ) - size_of_colony AS year_dev,
       id
  FROM ecoli_data
 ORDER BY year, year_dev;
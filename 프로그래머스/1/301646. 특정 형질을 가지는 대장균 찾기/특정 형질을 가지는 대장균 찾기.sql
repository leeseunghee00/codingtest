-- 2번 형질이 보유하지 않으면서 1번이나 3번 형질을 보유하고 있는 대장균 개체의 수(COUNT)를 출력
SELECT COUNT(*) AS 'count'
  FROM ecoli_data
 WHERE CONV(genotype, 10, 2) NOT LIKE '%1_'
   AND (CONV(genotype, 10, 2) LIKE '%1__'
    OR CONV(genotype, 10, 2) LIKE '%1');

-- 대장균의 ID(ID), 대장균의 형질(GENOTYPE), 부모 대장균의 형질(PARENT_GENOTYPE)을 출력
-- ID에 대해 오름차순 정렬
SELECT child.id AS id,
       child.genotype AS genotype,
       parent.genotype AS parent_genotype
  FROM ecoli_data child
  LEFT OUTER JOIN ecoli_data parent ON child.parent_id = parent.id
 WHERE child.genotype & parent.genotype = parent.genotype
 ORDER BY id;
-- 添加支持多子表的字段到gen_table表
ALTER TABLE gen_table 
ADD COLUMN sub_table_type TINYINT DEFAULT 1 COMMENT '子表关系类型（1一对一 2一对多）';
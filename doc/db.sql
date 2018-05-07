DROP TABLE IF EXISTS t_user;
create table t_user (
  id int primary key auto_increment comment '主键id',
  headId varchar(500) comment '头像',
  balance INT COMMENT '余额，单位：分',
  openId varchar(100) comment 'openid',
  unionId varchar(100) comment 'unionId',
  insertTime bigint comment '写入时间'
) CHARSET = utf8mb4 COMMENT '用户表';
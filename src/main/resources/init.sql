-- auto-generated definition
CREATE TABLE test_tb
(
  id       INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  name     VARCHAR(11) NULL,
  birthday DATE        NULL
)ENGINE = InnoDB CHARSET=utf8 COMMENT='单元测试使用';

DROP TABLE IF EXISTS `bbs_brand`;
CREATE TABLE `bbs_brand` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` VARCHAR(40) NOT NULL COMMENT '名称',
  `description` VARCHAR(80) DEFAULT NULL COMMENT '描述',
  `img_url` VARCHAR(80) DEFAULT NULL COMMENT '图片url',
  `web_site` VARCHAR(80) DEFAULT NULL COMMENT '品牌网址',
  `sort` INT(11) DEFAULT NULL COMMENT '排序；最大最靠前',
  `is_display` TINYINT(1) DEFAULT NULL COMMENT '是否可见 1:可见 0：不可见',
  PRIMARY KEY (`id`)
) ENGINE =InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8 COMMENT='品牌';

insert into `bbs_brand` VALUES(11,'莱尔瑜伽',null,null,null,89,'1');
insert into `bbs_brand` VALUES(12, '轻装服装',null,null,null,90,'1');
insert into `bbs_brand` VALUES(13, '艾米达',null,null,null,88,'1');
insert into `bbs_brand` VALUES(14, '哈他',null,null,null,78,'1');
insert into `bbs_brand` VALUES(15, '詹姆斯',null,null,null,78,'1');
insert into `bbs_brand` VALUES(16, '瑜伽树',null,null,null,68,'1');
insert into `bbs_brand` VALUES(17, '蓝一博人',null,null,null,70,'1');
insert into `bbs_brand` VALUES(18, 'Eff',null,null,null,48,'1');
insert into `bbs_brand` VALUES(19, '凯苏',null,null,null,58,'1');
insert into `bbs_brand` VALUES(20, '扶苏',null,null,null,68,'1');
insert into `bbs_brand` VALUES(21, '天蓝',null,null,null,68,'1');
insert into `bbs_brand` VALUES(22, '地方',null,null,null,55,'1');
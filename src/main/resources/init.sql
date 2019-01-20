# 测试
-- auto-generated definition
CREATE TABLE test_tb
(
  id       INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  name     VARCHAR(11) NULL,
  birthday DATE        NULL
)ENGINE = InnoDB CHARSET=utf8 COMMENT='单元测试使用';

# 品牌
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


# 商品
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'product_id',
  `name` VARCHAR(50) NOT NULL COMMENT '名称',
  `no` VARCHAR(20) NOT NULL COMMENT '款号',
  `year` VARCHAR(10) DEFAULT '2019' COMMENT '当前年份',
  `season` VARCHAR(4) DEFAULT '1111' COMMENT '季节,以四位二进制码进行标识',
  `sex` VARCHAR(4) DEFAULT '中性' COMMENT '男、女、中性',
  `keywords` VARCHAR(50) COMMENT '关键字 搜索用',
  `product_type_id` TINYINT COMMENT '商品类型, 商品类型表主键',
  `sell_type_id` TINYINT COMMENT '销售类型, 销售类型表主键',
  `is_alive` TINYINT DEFAULT '2' '上下架状态',
  `brand_id` TINYINT COMMENT '品牌表主键',
  `category_id` SMALLINT COMMENT '品类表主键',
  `shop_id` TINYINT COMMENT '商店表主键',
  `warehouse_id` TINYINT COMMENT '仓库表主键',
  `supplier_id` TINYINT COMMENT '供货商表主键',
  `product_style_id` TINYINT COMMENT '商品风格表主键',
  `product_story_id` TINYINT COMMENT '主题故事表主键',
  `add_time` DATETIME COMMENT '商品第一次录入的时间',
  `modify_admin_id` INT COMMENT '最后一次修改人',
  `modify_time` DATETIME COMMENT '最后一次修改商品的时间',
  PRIMARY KEY (`product_id`)
) ENGINE =InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8 COMMENT='品牌';
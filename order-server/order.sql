CREATE TABLE `order_sales` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(16) NOT NULL COMMENT '订单号',
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `order_status` tinyint(1) DEFAULT '0' COMMENT '订单状态',
  `is_deleted` tinyint(1) DEFAULT NULL COMMENT '是否删除 0 否 1 是',
  `modified_date` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `order_amount` decimal(10,2) unsigned DEFAULT NULL COMMENT '订单金额',
  `order_quantity` int(10) unsigned DEFAULT NULL COMMENT '订单数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='销售订单表';

CREATE TABLE `order_sales_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL COMMENT '销售订单id',
  `product_id` int(11) DEFAULT NULL COMMENT '商品id',
  `product_code` varchar(10) DEFAULT NULL COMMENT '商品编码',
  `product_name` varchar(64) DEFAULT NULL COMMENT '商品名称',
  `product_model` varchar(64) DEFAULT NULL COMMENT '商品型号',
  `product_price` decimal(10,2) unsigned DEFAULT NULL COMMENT '商品单价',
  `product_quantity` int(255) unsigned DEFAULT NULL COMMENT '商品数量',
  `subtotal` decimal(10,2) unsigned DEFAULT NULL COMMENT '小计',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='销售订单明细表';
ALTER TABLE `fuhuadata`.`customer_base_info`   
  CHANGE `enterprise_phone` `enterprise_phone` VARCHAR(40) CHARSET utf8mb4 COLLATE utf8mb4_general_ci NULL   COMMENT '企业电话',
  CHANGE `enterprise_email` `enterprise_email` VARCHAR(100) CHARSET utf8mb4 COLLATE utf8mb4_general_ci NULL   COMMENT '企业邮箱';

/*设置用户的采购产品唯一索引*/
ALTER TABLE `customer_purchase_product`
  DROP INDEX `uk_product_id_year`,
  ADD  UNIQUE INDEX `uk_customer_product_id_year` (`customer_id`, `product_id`, `year`);
ALTER TABLE `fuhuadata`.`customer_base_info`   
  CHANGE `enterprise_phone` `enterprise_phone` VARCHAR(40) CHARSET utf8mb4 COLLATE utf8mb4_general_ci NULL   COMMENT '企业电话',
  CHANGE `enterprise_email` `enterprise_email` VARCHAR(100) CHARSET utf8mb4 COLLATE utf8mb4_general_ci NULL   COMMENT '企业邮箱';
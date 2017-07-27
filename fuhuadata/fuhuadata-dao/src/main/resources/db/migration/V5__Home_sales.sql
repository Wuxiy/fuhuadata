ALTER TABLE `p_user_account`
  ADD COLUMN `user_type` TINYINT UNSIGNED NULL COMMENT '用户类型：1=外销用户，2=内销用户' AFTER `id`;

/* 内销地区表 */
CREATE TABLE `h_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL COMMENT '地区名称',
  `parent_id` int(11) DEFAULT NULL COMMENT '上级id',
  `parent_ids` varchar(100) DEFAULT NULL COMMENT '所有的上级id，使用逗号分隔',
  `weight` int(11) DEFAULT NULL COMMENT '权重',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='内销地区表';
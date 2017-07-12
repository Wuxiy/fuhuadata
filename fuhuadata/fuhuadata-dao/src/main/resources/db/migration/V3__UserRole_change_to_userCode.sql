/* p_user_role 添加 user_code 字段，使用 user_code 关联用户表 */
ALTER TABLE `p_user_role` ADD COLUMN `user_code` VARCHAR(20) DEFAULT '0' NOT NULL COMMENT '用户code' AFTER `user_id`;
/* 删除未关联的用户角色，脏数据 */
DELETE urd FROM `p_user_role` urd LEFT JOIN p_user_account ua ON ua.`id`=urd.`user_id` WHERE ua.`id` IS NULL AND urd.`user_code`='0';
/* 设置已有数据使用 code 关联 p_user_account 表 */
UPDATE `p_user_role` ur SET ur.`user_code` = (SELECT ua.code FROM p_user_account ua WHERE ua.id = ur.user_id) WHERE ur.user_id IS NOT NULL ;

/* p_user_area 添加 user_code 字段，并修改为使用该字段关联用户表（p_user_account） */
ALTER TABLE `p_user_area` ADD COLUMN `user_code` VARCHAR(20) DEFAULT '0' NOT NULL COMMENT '用户code' AFTER `user_id`;
/* 删除未关联的用户地区，脏数据 */
DELETE us_ar FROM `p_user_area` us_ar LEFT JOIN p_user_account ua ON ua.`id`=us_ar.`user_id` WHERE ua.`id` IS NULL AND us_ar.`user_code`='0';
/* 设置已有数据使用 code 关联 p_user_account 表 */
UPDATE `p_user_area` us_ar SET us_ar.`user_code` = (SELECT ua.code FROM p_user_account ua WHERE ua.id = us_ar.user_id) WHERE us_ar.user_id IS NOT NULL ;

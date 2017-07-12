/* 登录日志（p_user_login_log）添加登录人姓名 */
ALTER TABLE `p_user_login_log` ADD COLUMN `username` VARCHAR(20) NULL COMMENT '用户名称' AFTER `login_code`;

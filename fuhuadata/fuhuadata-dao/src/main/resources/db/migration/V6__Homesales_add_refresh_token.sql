/* 用户表添加 refresh token 字段，用于刷新 access accessToken */
ALTER TABLE `p_user_account`
  ADD COLUMN `refresh_token` VARCHAR(32) DEFAULT '' NOT NULL COMMENT 'refresh token，用于刷新access accessToken' AFTER `login_count`;

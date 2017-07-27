/* 初始化地区数据 */
/* 必须在 h_area 的 AUTO_INCREMENT=2 时执行，不然不能得到正确的上下级层级关系 */
/* 删除历史数据 */
TRUNCATE TABLE h_area;
/* 新增数据 */
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('1','西南','0','0,','1');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('2','重庆','1','0,1,','1');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('3','四川','1','0,1,','2');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('4','贵州','1','0,1,','3');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('5','华中','0','0,','2');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('6','湖南','5','0,5,','1');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('7','江西','6','0,5,','2');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('8','湖北','6','0,5,','3');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('9','福建','6','0,5,','4');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('10','云南（代管河北、河南）','0','0,','3');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('11','云南','10','0,10,','1');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('12','河南','10','0,10,','2');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('13','河北','10','0,10,','3');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('14','华南','0','0,','4');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('15','海南','14','0,14,','1');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('16','广东','14','0,14,','2');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('17','广西','14','0,14,','3');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('18','华北','0','0,','5');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('19','江苏','18','0,18,','1');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('20','浙江','18','0,18,','2');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('21','上海','18','0,18,','3');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('22','山西','18','0,18,','4');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('23','陕西','18','0,18,','5');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('24','甘肃','18','0,18,','6');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('25','宁夏','18','0,18,','7');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('26','青海','18','0,18,','8');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('27','安徽','18','0,18,','9');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('28','山东','18','0,18,','10');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('29','北方','0','0,','6');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('30','新疆','29','0,29,','1');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('31','东北','29','0,29,','2');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('32','内蒙','29','0,29,','3');

/* 初始化用户数据 */
/* 删除历史数据 */
delete from `p_user_account` where `user_type`=2;
/* 新增数据 */
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','赵魏','18781426489','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:56:11','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','周明月','18781426489','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:56:40','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','谭勇','18781426489','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:17','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','张瑞','18781426489','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:34','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','周昊','18781426489','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:56','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();

/* 初始化用户地区数据 */
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '赵魏' AND ha.name = '西南';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '周明月' AND ha.name = '四川';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '谭勇' AND ha.name = '四川';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '张瑞' AND ha.name = '贵州';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '周昊' AND ha.name = '贵州';
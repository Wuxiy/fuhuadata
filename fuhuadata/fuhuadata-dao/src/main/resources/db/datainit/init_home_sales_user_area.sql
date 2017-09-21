/* 初始化地区数据 */
/* 必须在 h_area 的 AUTO_INCREMENT=2 时执行，不然不能得到正确的上下级层级关系 */
/* 删除历史数据 */
TRUNCATE TABLE h_area;
/* 新增数据 */
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('1','西南','33','33,','1');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('2','重庆','1','33,1,','1');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('3','四川','1','33,1,','2');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('4','贵州','1','33,1,','3');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('5','华中','33','33,','2');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('6','湖南','5','33,5,','1');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('7','江西','6','33,5,','2');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('8','湖北','6','33,5,','3');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('9','福建','6','33,5,','4');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('10','云南（代管河北、河南）','33','33,','3');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('11','云南','10','33,10,','1');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('12','河南','10','33,10,','2');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('13','河北','10','33,10,','3');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('14','华南','33','33,','4');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('15','海南','14','33,14,','1');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('16','广东','14','33,14,','2');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('17','广西','14','33,14,','3');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('18','华北','33','33,','5');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('19','江苏','18','33,18,','1');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('20','浙江','18','33,18,','2');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('21','上海','18','33,18,','3');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('22','山西','18','33,18,','4');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('23','陕西','18','33,18,','5');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('24','甘肃','18','33,18,','6');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('25','宁夏','18','33,18,','7');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('26','青海','18','33,18,','8');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('27','安徽','18','33,18,','9');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('28','山东','18','33,18,','10');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('29','北方','33','33,','6');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('30','新疆','29','33,29,','1');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('31','东北','29','33,29,','2');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('32','内蒙','29','33,29,','3');
insert into `h_area` (`id`, `name`, `parent_id`, `parent_ids`, `weight`) values('33','全国','0','0,','1');

/* 初始化用户数据 */
/* 删除历史数据 */
delete from `p_user_account` where `user_type`=2;
/* 新增数据 */
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','赵魏','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:56:11','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','周明月','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:56:40','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','谭勇','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:17','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','张瑞','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:34','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','周昊','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:56','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','肖俊杰','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:56','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','胡国平','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:56','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','周阳','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:56','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','颜大印','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:56','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','王强','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:56','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','冯柯竣','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:56','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','黄光荣','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:56','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','唐六华','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:56','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','安黄勇','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:56','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','张吉豫','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:56','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','邵丹丹','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:56','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','王江博','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:56','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','喻强','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:56','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','郑力文','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:56','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','李斌','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:56','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','刘伟','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:56','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','王庆久','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:56','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','岑懋','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:56','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','陈炽','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:56','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','陈诚','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:56','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','董升升','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:56','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','郭伟平','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:56','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','赵浩楠','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:56','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','邱峰','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:56','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','许洪波','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:56','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','韩汶江','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:56','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();
insert into `p_user_account` (`user_type`, `login_name`, `login_password`, `name`, `mobile`, `birthdate`, `code`, `pk_group`, `pk_org`, `pk_psndoc`, `last_modify_time`, `login_ip`, `login_time`, `last_password`, `last_login_ip`, `last_login_time`, `login_count`) values('2','','123456','孟繁惠','','2017-07-27','',NULL,NULL,NULL,'2017-07-27 10:57:56','',NULL,'','',NULL,'0');
update `p_user_account` set `login_name`=last_insert_id(),`code`=last_insert_id() where id=last_insert_id();

/* 删除历史脏数据 */
/* 初始化用户地区数据 */
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '赵魏' AND ha.name = '西南';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '周明月' AND ha.name = '四川';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '谭勇' AND ha.name = '四川';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '张瑞' AND ha.name = '贵州';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '周昊' AND ha.name = '贵州';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '肖俊杰' AND ha.name = '华中';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '胡国平' AND ha.name = '湖南';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '周阳' AND ha.name = '湖南';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '颜大印' AND ha.name = '湖南';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '王强' AND ha.name = '江西';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '冯柯竣' AND ha.name = '湖北';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '黄光荣' AND ha.name = '福建';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '唐六华' AND ha.name = '云南（代管河北、河南）';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '安黄勇' AND ha.name = '云南';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '邵丹丹' AND ha.name = '河南';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '张吉豫' AND ha.name = '河南';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '王江博' AND ha.name = '河北';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '喻强' AND ha.name = '华南';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '郑力文' AND ha.name = '广东';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '李斌' AND ha.name = '广东';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '刘伟' AND ha.name = '广西';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '王庆久' AND ha.name = '广西';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '岑懋' AND ha.name = '广西';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '陈炽' AND ha.name = '华北';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '陈诚' AND ha.name = '山西';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '陈诚' AND ha.name = '陕西';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '陈诚' AND ha.name = '甘肃';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '陈诚' AND ha.name = '宁夏';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '陈诚' AND ha.name = '青海';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '董升升' AND ha.name = '安徽';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '郭伟平' AND ha.name = '山东';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '赵浩楠' AND ha.name = '山东';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '邱峰' AND ha.name = '新疆';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '许洪波' AND ha.name = '新疆';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '韩汶江' AND ha.name = '东北';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '韩汶江' AND ha.name = '内蒙';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '孟繁惠' AND ha.name = '东北';
insert into `p_user_area` (`user_code`, `area_id`) SELECT ua.code, ha.id FROM p_user_account ua, h_area ha WHERE ua.user_type=2 AND ua.name = '孟繁惠' AND ha.name = '内蒙';
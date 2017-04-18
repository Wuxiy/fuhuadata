/*INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('*', @menuid, '全部', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('add', @menuid, '新增', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('edit', @menuid, '更新', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('delete', @menuid, '删除', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('audit', @menuid, '审核', NULL, NULL);*/

/* 合作客户 */
SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='基本信息' AND p.menu_name='合作客户';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('edit', @menuid, '编辑', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('ewiki', @menuid, '编辑百科', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='市场信息' AND p.menu_name='合作客户';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('badd', @menuid, '采购产品新增', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('sadd', @menuid, '销售产品新增', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('cedit', @menuid, '合作情况编辑', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='联系人' AND p.menu_name='合作客户';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('add', @menuid, '新增', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='产品要求' AND p.menu_name='合作客户';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='订单信息' AND p.menu_name='合作客户';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='订单默认要求' AND p.menu_name='合作客户';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='沟通记录' AND p.menu_name='合作客户';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('add', @menuid, '新增', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='公司别名（子公司信息）' AND p.menu_name='合作客户';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('add', @menuid, '新增', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='关联数据' AND p.menu_name='合作客户';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);

/* 潜在客户 */
SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='基本信息' AND p.menu_name='潜在客户';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('edit', @menuid, '编辑', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('ewiki', @menuid, '编辑百科', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='市场信息' AND p.menu_name='潜在客户';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('badd', @menuid, '采购产品新增', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('sadd', @menuid, '销售产品新增', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('cedit', @menuid, '合作情况编辑', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='联系人' AND p.menu_name='潜在客户';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('add', @menuid, '新增', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='公司别名（子公司信息）' AND p.menu_name='潜在客户';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('add', @menuid, '新增', NULL, NULL);

/* 流失客户 */
SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='基本信息' AND p.menu_name='流失客户';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('edit', @menuid, '编辑', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('ewiki', @menuid, '编辑百科', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='市场信息' AND p.menu_name='流失客户';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('badd', @menuid, '采购产品新增', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('sadd', @menuid, '销售产品新增', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('cedit', @menuid, '合作情况编辑', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='联系人' AND p.menu_name='流失客户';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('add', @menuid, '新增', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='产品要求' AND p.menu_name='流失客户';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='订单信息' AND p.menu_name='流失客户';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='订单默认要求' AND p.menu_name='流失客户';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='沟通记录' AND p.menu_name='流失客户';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('add', @menuid, '新增', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='公司别名（子公司信息）' AND p.menu_name='流失客户';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('add', @menuid, '新增', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='关联数据' AND p.menu_name='流失客户';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);

/* 供应商信息 */
SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='加工厂' AND p.menu_name='供应商信息';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='货代' AND p.menu_name='供应商信息';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);

/* 销售统计 */
SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='销售流程' AND p.menu_name='销售统计';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('aoppo', @menuid, '新增商机', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('aoffe', @menuid, '新增报价', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='商机' AND p.menu_name='销售流程';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='基础信息' AND p.menu_name='商机';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('offer', @menuid, '报价', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('edit', @menuid, '编辑', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='跟进记录' AND p.menu_name='商机';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('add', @menuid, '新增', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='报价' AND p.menu_name='销售流程';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='订单' AND p.menu_name='销售流程';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='费用与利润' AND p.menu_name='销售统计';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='客户维护' AND p.menu_name='销售统计';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='利润统计' AND p.menu_name='销售统计';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='按地区' AND p.menu_name='利润统计';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='按客户' AND p.menu_name='利润统计';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='按业务员' AND p.menu_name='利润统计';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='按产品' AND p.menu_name='利润统计';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='我的历史订单' AND p.menu_name='销售统计';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);

/* 行业数据 */
SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='市场数据' AND p.menu_name='行业数据';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);

/* 知识库 */
SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='产品常见问题' AND p.menu_name='知识库';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('add', @menuid, '新增', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='营销培训' AND p.menu_name='知识库';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('add', @menuid, '新增', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='客户产品包装要求' AND p.menu_name='知识库';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='标准产品档案' AND p.menu_name='知识库';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('edit', @menuid, '编辑', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='包材成本参考' AND p.menu_name='知识库';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('add', @menuid, '新增', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='基础信息' AND p.menu_name='包材成本参考';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('edit', @menuid, '编辑', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='关联包材' AND p.menu_name='包材成本参考';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('add', @menuid, '新增', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('delete', @menuid, '删除', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='加工成本参考' AND p.menu_name='知识库';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='制剂加工费' AND p.menu_name='加工成本参考';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('edit', @menuid, '编辑', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('add', @menuid, '新增', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='国内运费' AND p.menu_name='加工成本参考';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('edit', @menuid, '编辑', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('add', @menuid, '新增', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='成分价格' AND p.menu_name='加工成本参考';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('edit', @menuid, '编辑', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('add', @menuid, '新增', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='港杂费' AND p.menu_name='加工成本参考';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('edit', @menuid, '编辑', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='费率' AND p.menu_name='加工成本参考';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('edit', @menuid, '编辑', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('add', @menuid, '新增', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='百科' AND p.menu_name='知识库';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('add', @menuid, '新增', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('edit', @menuid, '编辑', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='展会动态' AND p.menu_name='知识库';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('add', @menuid, '新增', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='其他' AND p.menu_name='知识库';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);

/* 决策支持 */
SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='销售数据' AND p.menu_name='决策支持';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='成本费用' AND p.menu_name='决策支持';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='数据库' AND p.menu_name='决策支持';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);

/* 系统管理 */
SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='数据字典维护' AND p.menu_name='系统管理';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='角色管理' AND p.menu_name='系统管理';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('add', @menuid, '新增', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('edit', @menuid, '编辑', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('delete', @menuid, '删除', NULL, NULL);

SELECT @menuid := m.menu_id FROM p_menu m INNER JOIN p_menu p ON p.menu_id=m.parent_id WHERE m.menu_name='菜单管理' AND p.menu_name='系统管理';
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('view', @menuid, '查看', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('add', @menuid, '新增', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('edit', @menuid, '编辑', NULL, NULL);
INSERT INTO `p_button` (`permission`, `menu_id`, `button_name`, `posturl`, `backup`) VALUES ('delete', @menuid, '删除', NULL, NULL);

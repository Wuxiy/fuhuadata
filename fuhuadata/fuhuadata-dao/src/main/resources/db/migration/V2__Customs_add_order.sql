# 海关数据国家表添加排序字段，默认按照字母排序，Other默认最后
ALTER TABLE `customs_country` ADD COLUMN `weight` INT DEFAULT 0  NOT NULL COMMENT '排序' AFTER `pid`;
UPDATE customs_country SET weight = 1 WHERE name = 'Argentina';
UPDATE customs_country SET weight = 2 WHERE name = 'Australia';
UPDATE customs_country SET weight = 3 WHERE name = 'Belarus';
UPDATE customs_country SET weight = 4 WHERE name = 'Brazil';
UPDATE customs_country SET weight = 5 WHERE name = 'Cameroon';
UPDATE customs_country SET weight = 6 WHERE name = 'Canada';
UPDATE customs_country SET weight = 7 WHERE name = 'Chile';
UPDATE customs_country SET weight = 8 WHERE name = 'Cote d\'lvoire';
UPDATE customs_country SET weight = 9 WHERE name = 'Denmark';
UPDATE customs_country SET weight = 10 WHERE name = 'Garner';
UPDATE customs_country SET weight = 11 WHERE name = 'India';
UPDATE customs_country SET weight = 12 WHERE name = 'Indonesia';
UPDATE customs_country SET weight = 13 WHERE name = 'Ireland';
UPDATE customs_country SET weight = 14 WHERE name = 'Israel';
UPDATE customs_country SET weight = 15 WHERE name = 'Japan';
UPDATE customs_country SET weight = 16 WHERE name = 'Kenya';
UPDATE customs_country SET weight = 17 WHERE name = 'Latvia';
UPDATE customs_country SET weight = 18 WHERE name = 'Malaysia';
UPDATE customs_country SET weight = 19 WHERE name = 'Mexico';
UPDATE customs_country SET weight = 20 WHERE name = 'Nigeria';
UPDATE customs_country SET weight = 21 WHERE name = 'Paraguay';
UPDATE customs_country SET weight = 22 WHERE name = 'Philippines';
UPDATE customs_country SET weight = 23 WHERE name = 'Russia';
UPDATE customs_country SET weight = 24 WHERE name = 'South Africa';
UPDATE customs_country SET weight = 25 WHERE name = 'South Korea';
UPDATE customs_country SET weight = 26 WHERE name = 'Thailand';
UPDATE customs_country SET weight = 27 WHERE name = 'Turkey';
UPDATE customs_country SET weight = 28 WHERE name = 'Ukraine';
UPDATE customs_country SET weight = 29 WHERE name = 'Uruguay';
UPDATE customs_country SET weight = 30 WHERE name = 'USA';
UPDATE customs_country SET weight = 31 WHERE name = 'Vietnam';
UPDATE customs_country SET weight = 32 WHERE name = 'Other Country';

# 海关数据公司表添加排序字段，并默认按照字母排序，Other Country默认最后
ALTER TABLE `customs_company` ADD COLUMN `weight` INT DEFAULT 0  NOT NULL COMMENT '排序' AFTER `pid`;
UPDATE `customs_company` SET `weight` = 1 WHERE `name` = 'Baocheng';
UPDATE `customs_company` SET `weight` = 2 WHERE `name` = 'CAC Nantong';
UPDATE `customs_company` SET `weight` = 3 WHERE `name` = 'Changshu pesticide factory';
UPDATE `customs_company` SET `weight` = 4 WHERE `name` = 'China Jiangsu International';
UPDATE `customs_company` SET `weight` = 5 WHERE `name` = 'Dongzhi Guangxin';
UPDATE `customs_company` SET `weight` = 6 WHERE `name` = 'Eastchem';
UPDATE `customs_company` SET `weight` = 7 WHERE `name` = 'Fuhua';
UPDATE `customs_company` SET `weight` = 8 WHERE `name` = 'Good Harvest';
UPDATE `customs_company` SET `weight` = 9 WHERE `name` = 'HDF';
UPDATE `customs_company` SET `weight` = 10 WHERE `name` = 'Huaxing';
UPDATE `customs_company` SET `weight` = 11 WHERE `name` = 'Hujiang';
UPDATE `customs_company` SET `weight` = 12 WHERE `name` = 'Jiahua';
UPDATE `customs_company` SET `weight` = 13 WHERE `name` = 'Jiahui';
UPDATE `customs_company` SET `weight` = 14 WHERE `name` = 'Jiangshan';
UPDATE `customs_company` SET `weight` = 15 WHERE `name` = 'Jinfanda';
UPDATE `customs_company` SET `weight` = 16 WHERE `name` = 'Jingma';
UPDATE `customs_company` SET `weight` = 17 WHERE `name` = 'Linhua';
UPDATE `customs_company` SET `weight` = 18 WHERE `name` = 'Ninhua';
UPDATE `customs_company` SET `weight` = 19 WHERE `name` = 'Nutrichem';
UPDATE `customs_company` SET `weight` = 20 WHERE `name` = 'Rainbow';
UPDATE `customs_company` SET `weight` = 21 WHERE `name` = 'Sanonda';
UPDATE `customs_company` SET `weight` = 22 WHERE `name` = 'Shenglian';
UPDATE `customs_company` SET `weight` = 23 WHERE `name` = 'Sinochem';
UPDATE `customs_company` SET `weight` = 24 WHERE `name` = 'Taicang pesticide factory';
UPDATE `customs_company` SET `weight` = 25 WHERE `name` = 'Wynca';
UPDATE `customs_company` SET `weight` = 26 WHERE `name` = 'Xingfa';
UPDATE `customs_company` SET `weight` = 27 WHERE `name` = 'Yangnong';
UPDATE `customs_company` SET `weight` = 28 WHERE `name` = 'Other';

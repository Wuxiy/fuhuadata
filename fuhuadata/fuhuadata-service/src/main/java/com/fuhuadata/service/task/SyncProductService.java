package com.fuhuadata.service.task;

import org.springframework.stereotype.Service;

/**
 * 同步产品档案
 * 步骤如下：
 * 1.将oracle的数据按名称分组同步到mysql的product_info表（以名称为唯一索引，存在则修改，不存在则插入）
 * 2.将oracle的数据不分组同步到mysql的product_ware表（以nc_id为唯一索引，存在则修改，不存在则插入）
 * 3.在mysql中补写product_info中的分类信息
 * 4.在mysql中补写product_ware中的product_info_info信息
 * Created by hexingfu on 2017/5/9.
 */
@Service("syncProduct")
public class SyncProductService {



}

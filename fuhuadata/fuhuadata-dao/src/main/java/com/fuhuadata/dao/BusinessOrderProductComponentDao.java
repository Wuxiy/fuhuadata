package com.fuhuadata.dao;

import com.fuhuadata.domain.BusinessOrderProductComponent;

import java.util.List;
import java.util.Map;

/**
 * Created by hexingfu on 2017/4/5.
 */
public interface BusinessOrderProductComponentDao {

    /**
     * 插入产品成分及费用
     * @param businessOrderProductComponents
     * @return
     */
     boolean insertProductComponent(List<BusinessOrderProductComponent> businessOrderProductComponents);

    /**
     * 通过复制档案插入产品成分及费用
     * @param map 必须参数：businessProductId 当前订单产品（表）id，businessProductArchivesId 客户产品档案id
     * @return
     */
     int insertFromArchives(Map<String,Object> map);

    /**
     * 根据订单产品表id获取成分及其费用
     * @param businessProductId
     * @return
     */
    List<BusinessOrderProductComponent> getProductComponentsByBusinessProductId(int businessProductId);

    /**
     * 根据产品查询该产品的成分及其费用
     * @param productId
     * @return
     */
    List<BusinessOrderProductComponent> getProductComponentsByProductId(int productId);
    /**
     * 批量更新
     * @param businessOrderProductComponents
     * @return
     */
    boolean updateProductComponent(List<BusinessOrderProductComponent> businessOrderProductComponents);

    /**
     * 复制businessProductId的产品成分到businessProductArchivesId为档案数据
     * @param map（businessProductArchivesId，businessProductId）
     * @return
     */
    int addArchives(Map<String,Object> map);

    /**
     * 复制businessProductId的最新产品成分更新其对应档案数据
     * @param businessProductId
     * @return
     */
    int updateArchives(Integer businessProductId);

    /**
     * 删除此订单或档案产品成分
     * @param type 1 删除当前订单的数据， -1 删除档案数据
     * @param businessProductId
     * @param wareId
     */
    public void deleteOrderProductComponent(int type,int businessProductId,int wareId);

    int getArchiveIdByBusinessProductId(int businessProductId);

}

package com.fuhuadata.dao;

import com.fuhuadata.domain.ProductWare;
import com.fuhuadata.vo.ProductWareVo;

import java.util.List;

/**
 * 产品规格型号
 * Created by intanswer on 2017/3/4.
 */
public interface ProductWareDao {

    public ProductWare addProductWare(ProductWare productWare);

    public int deleteProductWareById(int id);

    public int updateProductWareById(int id,ProductWare productWare);

    /**
     * 查询某种产品的规格型号
     * @param id
     * @return
     */
    public List<ProductWare> getProductWareByPId(int id);

    public ProductWare getProductWareById(int id);

    /**
     * 根据id查询数量
     * @param id
     * @return
     */
    public int countByPId(int id);

    /**
     * 查询添加订单产品时需要的产品基本信息
     * @param productWareVo
     * @return
     */
    public ProductWareVo getProductWareVo(ProductWareVo productWareVo);

}

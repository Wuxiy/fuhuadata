package com.fuhuadata.manager;

import com.fuhuadata.domain.ProductWare;

import java.util.List;

/**
 * 产品规格型号
 * Created by intanswer on 2017/3/4.
 */
public interface ProductWareManager {

    public ProductWare addProductWare(ProductWare productWare);

    public boolean deleteProductWareById(int id);

    public boolean updateProductWareById(int id,ProductWare productWare);

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


}

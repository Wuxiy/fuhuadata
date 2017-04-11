package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.ProductWareDao;
import com.fuhuadata.domain.ProductWare;
import com.fuhuadata.vo.ProductWareVo;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by intanswer on 2017/3/4.
 */
public class ProductWareDaoImpl extends SqlMapClientTemplate implements ProductWareDao {
    private static  final String ADD = "PRODUCTWARE.ADD";
    private static  final String UPDATE = "PRODUCTWARE.UPDATE";
    private static  final String DELETE_BY_ID = "PRODUCTWARE.DELETE-BY-ID";
    private static  final String GET_BY_ID = "PRODUCTWARE.GET-BY-ID";
    private static  final String GET_BY_PID = "PRODUCTWARE.GET-BY-PID";
    private static final String COUNT="PRODUCTWARE.COUNT";
    private static final String GET_PRODUCT_WARE_VO = "PRODUCTWARE.getProductWareVo";


    @Override
    public ProductWare addProductWare(ProductWare productWare) {
        productWare.setWareId((Integer)this.insert(ADD,productWare));
        return productWare;
    }

    @Override
    public int deleteProductWareById(int id) {
        return this.delete(DELETE_BY_ID,id);
    }

    @Override
    public int updateProductWareById(int id, ProductWare productWare) {
        productWare.setWareId(id);
        return this.update(UPDATE,productWare);
    }

    @Override
    public List<ProductWare> getProductWareByPId(int id) {
        return this.queryForList(GET_BY_PID,id);
    }

    @Override
    public ProductWare getProductWareById(int id) {
        return (ProductWare) this.queryForObject(GET_BY_ID,id);
    }

    @Override
    public int countByPId(int id) {
        return ((Integer)this.queryForObject(COUNT,id)).intValue();
    }

    @Override
    public ProductWareVo getProductWareVo(ProductWareVo productWareVo) {
        return (ProductWareVo)this.queryForObject(GET_PRODUCT_WARE_VO,productWareVo);
    }
}

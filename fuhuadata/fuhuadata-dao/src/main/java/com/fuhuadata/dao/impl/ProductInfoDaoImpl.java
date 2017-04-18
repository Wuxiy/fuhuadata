package com.fuhuadata.dao.impl;
import java.math.BigDecimal;
import java.util.List;

import com.fuhuadata.domain.ProductComponent;
import com.fuhuadata.domain.ProductInfo;
import com.fuhuadata.domain.query.QueryProductInfo;
import com.fuhuadata.dao.ProductInfoDao;


import com.fuhuadata.vo.CustomerProductPackagingArchives;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.aop.support.AopUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
/**
 * @author wangbo
 * @date 2017-01-24 10:45:54
 */

public class ProductInfoDaoImpl extends SqlMapClientTemplate implements ProductInfoDao {

    public static final String ADD = "PRODUCTINFO.ADD";
    public static final String UPDATE = "PRODUCTINFO.UPDATE";
    public static final String DELETE_BY_ID = "PRODUCTINFO.DELETE-BY-ID";
    public static final String GET_ALL = "PRODUCTINFO.GET-ALL";
    public static final String GET_BY_QUERY = "PRODUCTINFO.GET-BY-QUERY";
    public static final String GET_BY_ID = "PRODUCTINFO.GET-BY-ID";
    public static final String GET_BY_PID="PRODUCTINFO.GET-BY-PID";
    public static final String GET_PAGE = "PRODUCTINFO.GET-PAGE";
    public static final String COUNT = "PRODUCTINFO.COUNT";
    public static final String ADD_PRODUCT_PROCESSING_COMPONENT="PRODUCTINFO.ADD-PRODUCT-PROCESSING-COMPONENTS";
    public static final String  DELETE_PROCESSING_COMPONENT_BY_ID="PRODUCTINFO.DELETE-PROCESSING-COMPONENTS-BY-ID";
    public static final String GET_PRODUCT_COMPONENT_BY_PRODUCT_ID="PRODUCTINFO.GET-PRODUCT-COMPONENT-BY-ID";
    public static final String GET_CUSTOMS_CLEARANCE_INFO = "PRODUCTINFO.getCustomsClearanceInfo";
    public static final String GET_RISETAXES = "PRODUCTINFO.getRisetaxes";
    
    public ProductInfo addProductInfo(ProductInfo productInfo) {
		productInfo.setProductId((Integer) this.insert(ADD, productInfo));
    	return productInfo;
    }
    
    public int updateProductInfoById(int product_id, ProductInfo productInfo) {
    	productInfo.setProductId(product_id);
		return this.update(UPDATE, productInfo);
    }
    
    public int deleteProductInfoById(int product_id) {
    	return this.delete(DELETE_BY_ID, product_id);
    }

    @Override
    public int addProductProcessingComponent(List<ProductComponent> productComponents) {
        return this.update(ADD_PRODUCT_PROCESSING_COMPONENT,productComponents);
    }

    @Override
    public int deleteProductProcessingComponent(int productId) {
        return this.delete(DELETE_PROCESSING_COMPONENT_BY_ID,productId);
    }

    @Override
    public List<ProductInfo> getProductInfoByPId(int id) {
        return this.queryForList(GET_BY_PID,id);
    }

    public List<ProductInfo> getAllProductInfos() {
    	return this.queryForList(GET_ALL);
    }
    	
    public List<ProductInfo> getProductInfosByQuery(QueryProductInfo queryProductInfo) {
    	return this.queryForList(GET_BY_QUERY, queryProductInfo);
    }
    	
    public ProductInfo getProductInfoById(int product_id) {
    	return (ProductInfo) this.queryForObject(GET_BY_ID, product_id);
    }

    @Override
    public List<ProductComponent> getProductComponentByProductId(int product_id) {
        return this.queryForList(GET_PRODUCT_COMPONENT_BY_PRODUCT_ID,product_id);
    }


    public List<ProductInfo> getProductInfosByPage(QueryProductInfo queryProductInfo) {
    	return this.queryForList(GET_PAGE, queryProductInfo);
    }
    	
    public int count(QueryProductInfo queryProductInfo) {
    	return ((Integer) this.queryForObject(COUNT, queryProductInfo)).intValue();
    }

    @Override
    public ProductInfo getCustomsClearanceInfo(Integer productId) {
        try {
            return (ProductInfo)this.queryForObject(GET_CUSTOMS_CLEARANCE_INFO,productId);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BigDecimal getRisetaxes(Integer productId) {
        return (BigDecimal)this.queryForObject(GET_RISETAXES,productId);
    }
}
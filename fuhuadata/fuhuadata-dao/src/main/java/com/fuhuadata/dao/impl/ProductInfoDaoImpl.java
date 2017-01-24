package com.fuhuadata.dao.impl;
import java.util.List;
import com.fuhuadata.domain.ProductInfo;
import com.fuhuadata.domain.query.QueryProductInfo;
import com.fuhuadata.dao.ProductInfoDao;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
/**
 * @author wangbo
 * @date 2017-01-24 10:45:54
 */
@SuppressWarnings("unchecked")
@Component
public class ProductInfoDaoImpl extends SqlMapClientTemplate implements ProductInfoDao {

    public static final String ADD = "PRODUCTINFO.ADD";
    public static final String UPDATE = "PRODUCTINFO.UPDATE";
    public static final String DELETE_BY_ID = "PRODUCTINFO.DELETE-BY-ID";
    public static final String GET_ALL = "PRODUCTINFO.GET-ALL";
    public static final String GET_BY_QUERY = "PRODUCTINFO.GET-BY-QUERY";
    public static final String GET_BY_ID = "PRODUCTINFO.GET-BY-ID";
    public static final String GET_PAGE = "PRODUCTINFO.GET-PAGE";
    public static final String COUNT = "PRODUCTINFO.COUNT";
    
    public ProductInfo addProductInfo(ProductInfo productInfo) {
		productInfo.setProductId((Integer) this.insert(ADD, productInfo));
    	return productInfo;
    }
    
    public int updateProductInfoById(int product_id, ProductInfo productInfo) {
    	productInfo.setProductId(product_id);
		return this.update(UPDATE, productInfo);
    }
    
    public int deleteProductInfoById(int product_id) {
    	return this.update(DELETE_BY_ID, product_id);
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
    
    public List<ProductInfo> getProductInfosByPage(QueryProductInfo queryProductInfo) {
    	return this.queryForList(GET_PAGE, queryProductInfo);
    }
    	
    public int count(QueryProductInfo queryProductInfo) {
    	return ((Integer) this.queryForObject(COUNT, queryProductInfo)).intValue();
    }
}
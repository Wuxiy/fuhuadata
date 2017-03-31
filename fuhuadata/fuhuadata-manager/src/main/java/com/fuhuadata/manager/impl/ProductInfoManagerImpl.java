package com.fuhuadata.manager.impl;
import java.util.List;

import com.fuhuadata.domain.ProductComponent;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.ProductInfo;
import com.fuhuadata.manager.ProductInfoManager;
import com.fuhuadata.domain.query.QueryProductInfo;
import com.fuhuadata.dao.ProductInfoDao;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * @author wangbo
 * @date 2017-01-24 10:45:54
 */
public class ProductInfoManagerImpl implements ProductInfoManager {

    private ProductInfoDao productInfoDao;

	@Transactional
    public ProductInfo addProductInfo(ProductInfo productInfo,List<ProductComponent> productComponents) {
    	productInfoDao.addProductProcessingComponent(productComponents);
    	return productInfoDao.addProductInfo(productInfo);
    }

    @Transactional
    public boolean updateProductInfoById(int product_id, ProductInfo productInfo,List<ProductComponent> productComponents) {
    	productInfoDao.deleteProductProcessingComponent(product_id);
    	productInfoDao.addProductProcessingComponent(productComponents);
    	return productInfoDao.updateProductInfoById(product_id, productInfo) == 1 ? true : false;
    }
    
	public List<ProductInfo> getProductInfosByQuery(QueryProductInfo queryProductInfo) {
		return productInfoDao.getProductInfosByQuery(queryProductInfo);
	}

    public boolean deleteProductInfoById(int product_id) {
    	return productInfoDao.deleteProductInfoById(product_id) == 1 ? true : false;
    }
    
    
    public List<ProductInfo> getAllProductInfos() {
    	return productInfoDao.getAllProductInfos();
    }
    	
    public Result<List<ProductInfo>> getProductInfosByPage(QueryProductInfo queryProductInfo) {
		Result<List<ProductInfo>> result = new Result<List<ProductInfo>>();
		int totalItem = productInfoDao.count(queryProductInfo);
		;
		if (totalItem > 0) {
			result.addDefaultModel("ProductInfos", productInfoDao.getProductInfosByPage(queryProductInfo));		
		} else {
			result.addDefaultModel("ProductInfos", new ArrayList<ProductInfo>());
		}
		
		result.setPageSize(queryProductInfo.getPageSize());
		result.setIndex(queryProductInfo.getIndex());
		result.setTotalItem(totalItem);
		
		return result;
    }
    	
    	
    public ProductInfo getProductInfoById(int product_id) {
    	return productInfoDao.getProductInfoById(product_id);
    }

	@Override
	public List<ProductInfo> getProductInfoByPId(int id) {
		System.out.println(id);
		return productInfoDao.getProductInfoByPId(id);
	}


	public int count(QueryProductInfo queryProductInfo) {
    	return productInfoDao.count(queryProductInfo);
    }

	public void setProductInfoDao(ProductInfoDao productInfoDao) {
		this.productInfoDao = productInfoDao;
	}
	public ProductInfoDao getProductInfoDao(){
    	return this.productInfoDao;
	}
}
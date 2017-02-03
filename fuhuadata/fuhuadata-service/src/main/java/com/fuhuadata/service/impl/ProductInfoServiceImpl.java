package com.fuhuadata.service.impl;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.ProductInfo;
import com.fuhuadata.manager.ProductInfoManager;
import com.fuhuadata.service.ProductInfoService;
import com.fuhuadata.domain.query.QueryProductInfo;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author wangbo
 * @date 2017-01-24 10:45:54
 */
public class ProductInfoServiceImpl implements ProductInfoService {
	
    private ProductInfoManager productInfoManager;
    public Result<ProductInfo> addProductInfo(ProductInfo productInfo) {
		Result<ProductInfo> result = new Result<ProductInfo>();
		try {
			result.addDefaultModel(productInfoManager.addProductInfo(productInfo));			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result updateProductInfoById(int product_id, ProductInfo productInfo) {
		Result result = new Result();
		try {
			result.setSuccess(productInfoManager.updateProductInfoById(product_id, productInfo));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result deleteProductInfoById(int product_id) {
		Result result = new Result();
		try {
			result.setSuccess(productInfoManager.deleteProductInfoById(product_id));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }	
    	
    public Result<List<ProductInfo>> getProductInfosByQuery(QueryProductInfo queryProductInfo) {
		Result<List<ProductInfo>> result = new Result<List<ProductInfo>>();
		try {
			result.addDefaultModel("${!className}s", productInfoManager.getProductInfosByQuery(queryProductInfo));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<ProductInfo> getProductInfoById(int product_id) {
		Result<ProductInfo> result = new Result<ProductInfo>();
		try {		
		    ProductInfo  productInfo = productInfoManager.getProductInfoById(product_id);
		    if(productInfo == null){
				result.setSimpleErrorMsg(0, "当前数据不存在，请重试");
			}else{
				result.addDefaultModel("ProductInfo", productInfo);
			}
			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    

    public Result<List<ProductInfo>> getProductInfosByPage(QueryProductInfo queryProductInfo) {
		Result<List<ProductInfo>> result = new Result<List<ProductInfo>>();
		try {		
			result = productInfoManager.getProductInfosByPage(queryProductInfo);
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<Integer> count(QueryProductInfo queryProductInfo) {
		Result<Integer> result = new Result<Integer>();
		try {	
			result.addDefaultModel(productInfoManager.count(queryProductInfo));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
	
}
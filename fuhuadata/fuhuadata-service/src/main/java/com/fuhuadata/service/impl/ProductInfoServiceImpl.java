package com.fuhuadata.service.impl;
import java.util.List;

import com.fuhuadata.dao.ProductWareDao;
import com.fuhuadata.domain.ComponentCost;
import com.fuhuadata.domain.ProductWare;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.ProductInfo;
import com.fuhuadata.manager.ProductInfoManager;
import com.fuhuadata.manager.ProductWareManager;
import com.fuhuadata.service.ProductInfoService;
import com.fuhuadata.domain.query.QueryProductInfo;

import com.fuhuadata.util.JsonUtils;
import com.fuhuadata.vo.PhysicalProperities;
import com.fuhuadata.vo.ProductInfoVO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author wangbo
 * @date 2017-01-24 10:45:54
 */
public class ProductInfoServiceImpl implements ProductInfoService {
	private  final static Log log = LogFactory.getLog(ProductProblemServiceImpl.class);
    private ProductInfoManager productInfoManager;
    private ProductWareManager productWareManager;
    public Result<ProductInfo> addProductInfo(ProductInfo productInfo) {
		Result<ProductInfo> result = new Result<ProductInfo>();
		try {
			result.addDefaultModel(productInfoManager.addProductInfo(productInfo));			
		} catch(Exception e) {
			result.setSuccess(false);
			log.error("新增产品档案错误",e);
		}
		return result;
    }
    
    public Result updateProductInfoById(int product_id, ProductInfo productInfo) {
		Result result = new Result();
		try {
			String str=productInfo.getProcessingComponents();
			result.setSuccess(productInfoManager.updateProductInfoById(product_id, productInfo));
		} catch(Exception e) {
			result.setSuccess(false);
			log.error("根据id更新产品档案信息错误",e);
		}
		return result;
    }
    
    public Result deleteProductInfoById(int product_id) {
		Result result = new Result();
		try {
			result.setSuccess(productInfoManager.deleteProductInfoById(product_id));
		} catch(Exception e) {
			result.setSuccess(false);
			log.error("根据id删除产品档案信息错误",e);
		}
		return result;
    }	
    	
    public Result<List<ProductInfo>> getProductInfosByQuery(QueryProductInfo queryProductInfo) {
		Result<List<ProductInfo>> result = new Result<List<ProductInfo>>();
		try {
			result.addDefaultModel("${!className}s", productInfoManager.getProductInfosByQuery(queryProductInfo));
		} catch(Exception e) {
			result.setSuccess(false);
			log.error("获取产品档案列表错误",e);
		}
		return result;	
    }

	/**
	 * 产品档案详情
	 * @param product_id
	 * @return
	 */
	public Result<ProductInfoVO> getProductInfoById(int product_id) {
		Result<ProductInfoVO> result = new Result<ProductInfoVO>();
		ProductInfoVO productInfoVO =new ProductInfoVO();
		try {		
		    ProductInfo  productInfo = productInfoManager.getProductInfoById(product_id);

		    if(productInfo == null){
				result.setSimpleErrorMsg(0, "当前数据不存在，请重试");
			}else {
		    	if(productInfo.getMidCategoryId()!=8) {
					if (productInfo.getPhysicalProperities() != null && productInfo.getPhysicalProperities().length() > 0) {
						JSONArray json = JSONArray.fromObject(productInfo.getPhysicalProperities()); // 首先把字符串转成JSONArray对象
						if (json.size() > 0) {
							for (int i = 0; i < json.size(); i++) {
								JSONObject job = json.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
								PhysicalProperities physicalProperities = new PhysicalProperities();
								physicalProperities.setIndex((String) job.get("index"));
								physicalProperities.setValue((String) job.get("value"));
								physicalProperities.setRemarks((String) job.get("remarks"));
								productInfoVO.addIndex(physicalProperities);
							}
						}
					}
					if (productInfo.getProcessingComponents() != null && productInfo.getProcessingComponents().length() > 0) {
							JSONArray cJson = JSONArray.fromObject(productInfo.getProcessingComponents());
							if (cJson.size() > 0) {
								for (int i = 0; i < cJson.size(); i++) {
									JSONObject cjob = cJson.getJSONObject(i);
									ComponentCost componentCost = new ComponentCost();
									componentCost.setComponentName((String) cjob.get("componentName"));
									componentCost.setConsumption((String) cjob.get("consumption"));
									componentCost.setRemarks((String) cjob.get("remarks"));
									productInfoVO.addProcessingComponents(componentCost);
								}
							}
						}
				}
					productInfoVO.setProductInfo(productInfo);
					productInfoVO.setWares(productWareManager.getProductWareByPId(product_id));
					result.addDefaultModel("ProductInfo", productInfoVO);
			}
		} catch(Exception e) {
			result.setSuccess(false);
			log.error("根据id获取产品信息错误",e);
		}
		return result;	
    }

	@Override
	public Result<List<ProductInfo>> getProductInfoByPId(int id) {
		Result<List<ProductInfo>> result = new Result<List<ProductInfo>>();
		try{
			result.addDefaultModel("ProductInfo",productInfoManager.getProductInfoByPId(id));
		}catch(Exception e){
			result.setSuccess(false);
			log.error("根据PId查询产品类错误",e);
		}
		return result;
	}


	public Result<List<ProductInfo>> getProductInfosByPage(QueryProductInfo queryProductInfo) {
		Result<List<ProductInfo>> result = new Result<List<ProductInfo>>();
		try {		
			result = productInfoManager.getProductInfosByPage(queryProductInfo);
		} catch(Exception e) {
			result.setSuccess(false);
			log.error("分页获取产品档案错误",e);
		}
		return result;	
    }
    	
    public Result<Integer> count(QueryProductInfo queryProductInfo) {
		Result<Integer> result = new Result<Integer>();
		try {	
			result.addDefaultModel(productInfoManager.count(queryProductInfo));
		} catch(Exception e) {
			result.setSuccess(false);
			log.error("获取产品档案数量错误",e);
		}
		return result;	
    }

	public void setProductInfoManager(ProductInfoManager productInfoManager) {
		this.productInfoManager = productInfoManager;
	}

	public ProductInfoManager getProductInfoManager(){
    	return this.productInfoManager;
	}

	public void setProductWareManager(ProductWareManager productWareManager) {
		this.productWareManager = productWareManager;
	}

	public ProductWareManager getProductWareManager(){
		return this.productWareManager;
	}
}
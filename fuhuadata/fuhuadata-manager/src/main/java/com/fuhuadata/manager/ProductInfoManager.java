package com.fuhuadata.manager;
import java.util.List;

import com.fuhuadata.domain.ProductComponent;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.ProductInfo;
import com.fuhuadata.domain.query.QueryProductInfo;
import com.fuhuadata.vo.ProductInfoVO;

import java.util.Map;
import java.io.Serializable;

/**
 * @author wangbo
 * @date 2017-01-24 10:45:54
 */
public interface ProductInfoManager {
	/**
	 * 新增 productInfo,返回productInfo对象(设置了新生成id)
	 * @param productInfo
	 * @return
	 */
    public ProductInfo addProductInfo(ProductInfo productInfo, List<ProductComponent> productComponents) ;
    
	 /**
     * 按照主键id更新productInfo，请重新new ProductInfo 的更新对象，设置要更新的字段
	 * 成功返回true，失败返回false
     * @param product_id
     * @param productInfo
     * @return
     */
    public boolean updateProductInfoById(int product_id,ProductInfo productInfo,List<ProductComponent> productComponents);

    /**
     * 按照主键id 删除 记录
	 * 成功返回true，失败返回false
     * @param product_id
     * @return
     */
    public boolean deleteProductInfoById(int product_id);

    /**
     * 返回数据库所有记录，谨慎使用，最好不用
     * @return
     */
    public List<ProductInfo> getAllProductInfos();
    
	/**
     * 查询列表，此接口不包含分页查询，查询结果为空返回空的List对象
     * @param queryProductInfo
     * @return
     */    	
    public List<ProductInfo> getProductInfosByQuery(QueryProductInfo queryProductInfo);

    /**
     * 通过主键id查询ProductInfo
	 * 查询不到返回NULL值
     * @param product_id
     * @return
     */
    public ProductInfoVO getProductInfoById(int product_id);

	/**
	 * 根据产品分类查询
	 * @param id
	 * @return
	 */
	public List<ProductInfo> getProductInfoByPId(int id);

    /**
     * 查询列表，包含分页查询，
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回Result中，可以通过result.getTotal()返回结果总数，
	 * result中包装了分页需要的信息，和当前列表
     * @param queryProductInfo
     * @return
     */
    public Result<List<ProductInfo>> getProductInfosByPage(QueryProductInfo queryProductInfo);

    /**
     * 查询总数
     * @param queryProductInfo
     * @return
     */
    public int count(QueryProductInfo queryProductInfo);
	
}
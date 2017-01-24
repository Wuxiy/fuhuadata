package com.fuhuadata.dao;
import java.util.List;
import com.fuhuadata.domain.ProductInfo;
import com.fuhuadata.domain.query.QueryProductInfo;

/**
 * @author wangbo
 * @date 2017-01-24 10:45:54
 */
public interface ProductInfoDao {
	/**
	 * 新增 productInfo,返回productInfo对象(设置了新生成id)
	 * @param productInfo
	 * @return
	 */
    public ProductInfo addProductInfo(ProductInfo productInfo);
    
	 /**
     * 按照主键id更新productInfo，成功返回1，使用接口时，请重新new ProductInfo 的更新对象，设置要更新的字段
     * @param product_id
     * @param productInfo
     * @return
     */
    public int updateProductInfoById(int product_id, ProductInfo productInfo);
    
	 /**
     * 按照主键id 删除 记录，返回1为成功
     * @param product_id
     * @return
     */
    public int deleteProductInfoById(int product_id);
    
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
     * 通过主键id查询ProductInfo，查询不到返回NULL值
     * @param product_id
     * @return
     */
    public ProductInfo getProductInfoById(int product_id);
        
	 /**
     * 查询列表，包含分页查询，查询结果为空返回空的List对象
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
     * @param queryProductInfo
     * @return
     */
    public List<ProductInfo> getProductInfosByPage(QueryProductInfo queryProductInfo);
    	
	 /**
     * 查询总数
     * @param queryProductInfo
     * @return
     */
    public int count(QueryProductInfo queryProductInfo);
    		
}
package com.fuhuadata.dao;
import java.math.BigDecimal;
import java.util.List;

import com.fuhuadata.domain.ProductCategory;
import com.fuhuadata.domain.ProductComponent;
import com.fuhuadata.domain.ProductInfo;
import com.fuhuadata.domain.query.QueryProductInfo;
import com.fuhuadata.vo.CustomerProductPackagingArchives;

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


    public int addProductProcessingComponent(List<ProductComponent> productComponents);

	/**
	 * 根据标准产品ID删除产品加工成分
	 * @param productId
	 * @return
	 */
	public int deleteProductProcessingComponent(int productId);

	/**
	 * 根据产品分类查询
	 * @param id
	 * @return
	 */
	public List<ProductInfo> getProductInfoByPId(int id);
    
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

    public List<ProductComponent> getProductComponentByProductId(int product_id);


        
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

	/**
	 * 根据产品id获取对应报关产品编码和名称
	 * @param productId
	 * @return
	 */
	public ProductInfo getCustomsClearanceInfo(Integer productId);

	/**
	 * 获取产品增值税税率
	 * @param wareId
	 * @return
	 */
	public BigDecimal getRisetaxes(Integer wareId);
    		
}
package com.fuhuadata.service;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.ProductInfo;
import com.fuhuadata.domain.query.QueryProductInfo;
import java.util.Map;
import java.io.Serializable;

/**
 * @author wangbo
 * @date 2017-01-24 10:45:54
 */
public interface ProductInfoService {

	/**
	 * 新增 productInfo
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到新增 productInfo
	 * @param productInfo
	 * @return
	 */
    public Result<ProductInfo> addProductInfo(ProductInfo productInfo) ;
 
    /**
     * 按照主键id更新productInfo，请重新new ProductInfo 的更新对象，设置要更新的字段
	 * 返回result，通过result.isSuccess()判断更新是否成功
     * @param product_id
     * @param productInfo
     * @return
     */
    public Result updateProductInfoById(int product_id, ProductInfo productInfo);

    /**
     * 按照主键id 删除 记录
	 * 返回result，通过result.isSuccess()判断删除是否成功
     * @param product_id
     * @return
     */
    public Result deleteProductInfoById(int product_id);
    
    /**
     * 查询列表，此接口不包含分页查询
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到列表信息
     * @param queryProductInfo
     * @return
     */
    public Result<List<ProductInfo>> getProductInfosByQuery(QueryProductInfo queryProductInfo);

    /**
     * 通过主键id查询ProductInfo
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到查询的单条productInfo信息
     * @param product_id
     * @return
     */
    public Result<ProductInfo> getProductInfoById(int product_id);

	/**
	 * 根据产品分类返回
	 * @param id
	 * @return
	 */
	public Result<List<ProductInfo>> getProductInfoByPId(int id);

    /**
     * 查询列表，包含分页查询
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getTotal()返回结果总数
	 * 通过result.getModel()得到查询的单页列表信息
     * @param queryProductInfo
     * @return
     */
    public Result<List<ProductInfo>> getProductInfosByPage(QueryProductInfo queryProductInfo);

    /**
     * 查询总数
     * @param queryProductInfo
     * @return
     */
    public Result<Integer> count(QueryProductInfo queryProductInfo);
	
}
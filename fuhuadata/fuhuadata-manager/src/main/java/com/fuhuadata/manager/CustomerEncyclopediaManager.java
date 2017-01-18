package com.fuhuadata.manager;

import com.fuhuadata.domain.CustomerEncyclopedia;
import com.fuhuadata.domain.query.CustomerEncyclopediaQuery;
import com.fuhuadata.domain.query.Result;

import java.util.List;

/**
 * 客户百科Manager
 * Created by wuxi on 2017/1/13.
 */
public interface CustomerEncyclopediaManager {

    /**
     * 新增CustomerEncyclopedia，返回CustomerEncyclopedia对象（设置了新生成的）
     * @param customerEncyclopedia
     * @return
     */
    public CustomerEncyclopedia addCustomerEncyclopedia(CustomerEncyclopedia customerEncyclopedia);

    public boolean updateCustomerEncyclopediaById(int id, CustomerEncyclopedia customerEncyclopedia);


    /**
     * 根据主键id删除客户百科
     * @param id
     * @return
     */
    public boolean deleteCustomerEncyclopediaById(int id);

    /**
     * 查询列表，包含分页查询，
     * 查询分页信息，请设置
     * Query(设置当前页数)
     * Query(设置当前页面数据行数)
     * 返回Result中，可以通过result.getTotal()返回结果总数，
     * result中包装了分页需要的信息，和当前列表
     * @param customerEncyclopediaQuery
     * @return
     */

    public Result<List<CustomerEncyclopedia>> getCustomerEncyclopediasByPage(CustomerEncyclopediaQuery customerEncyclopediaQuery);

    /**
     * 查询总数
     * @param customerEncyclopediaQuery
     * @return
     */
    public int count(CustomerEncyclopediaQuery customerEncyclopediaQuery);

}

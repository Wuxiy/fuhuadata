package com.fuhuadata.dao;

import com.fuhuadata.domain.CustomerEncyclopedia;
import com.fuhuadata.domain.query.CustomerEncyclopediaQuery;

import java.util.List;

/**
 * 客户百科dao
 * Created by intanswer on 2017/1/13.
 */
public interface CustomerEncyclopediaDao {
    /**
     * 新增客户百科
     * @param customerEncyclopedia
     * @return
     */
    public CustomerEncyclopedia addCustomerEncyclopedia(CustomerEncyclopedia customerEncyclopedia);

    /**
     * 根据id更新客户百科信息，成功返回1
      * @param id
     * @param customerEncyclopedia
     * @return
     */
    public int updateCustomerEncyclopediaById(int id, CustomerEncyclopedia customerEncyclopedia);

    /**
     * 根据主键id删除记录，成功删除返回1
     * @param id
     * @return
     */
    public int deleteCustomerEncyclopediaById(int id);

    /**
     * 查询列表，包含分页查询，查询结果为空返回空的List对象
     * 查询分页信息，请设置
     * Query(设置当前页数)
     * Query(设置当前页面数据行数)
     * @param customerEncyclopediaQuery
     * @return
     */
    public List<CustomerEncyclopedia> getCustomerEncyclopediasByPage(CustomerEncyclopediaQuery customerEncyclopediaQuery);
    /**
     * 查询总数
     * @param customerEncyclopediaQuery
     * @return
     */
    public int count(CustomerEncyclopediaQuery customerEncyclopediaQuery);



}

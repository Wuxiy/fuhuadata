package com.fuhuadata.service;

import com.fuhuadata.domain.CustomerEncyclopedia;
import com.fuhuadata.domain.query.CustomerEncyclopediaQuery;
import com.fuhuadata.domain.query.Result;

import java.util.List;

/**
 * 客户百科service
 * Created by intanswer on 2017/1/16.
 */
public interface CustomerEncyclopediaService {
    /**
     * 新增CustomerEncyclopedia
     * 返回result ,通过result.isSuccess(）判断服务调用是否成功
     * 通过result.getModel(）得到新增 CustomerEncyclopedia
     * @param customerEncyclopedia
     * @return
     */
    public Result<CustomerEncyclopedia> addCustomerEncyclopedia(CustomerEncyclopedia customerEncyclopedia);

    /**
     * 按照主键id更新CustomerEncyclopedia，请重新new CustomerEncyclopedia 的更新对象，设置要更新的字段
     * 返回result，通过result.isSuccess()判断删除是否成功
     * @param id
     * @param customerEncyclopedia
     * @return
     */
    public Result updateCustomerEncyclopediaById(int id, CustomerEncyclopedia customerEncyclopedia);

    /**
     * 按照主键id删除记录
     * 返回result，通过result.isSuccess()判断删除是否成功
     * @param id
     * @return
     */
    public Result deleteCustomerEncyclopediaById(int id);

    public Result<List<CustomerEncyclopedia>> getCustomerEncyclopediasByPage(CustomerEncyclopediaQuery customerEncyclopediaQuery);

    public Result<Integer> count(CustomerEncyclopediaQuery customerEncyclopediaQuery);


}

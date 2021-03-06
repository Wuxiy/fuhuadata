package com.fuhuadata.manager.impl;

import com.fuhuadata.dao.CustomerBaseInfoDao;
import com.fuhuadata.dao.CustomerEncyclopediaDao;
import com.fuhuadata.domain.CustomerBaseInfo;
import com.fuhuadata.domain.CustomerEncyclopedia;

import com.fuhuadata.domain.query.CustomerEncyclopediaQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.CustomerEncyclopediaManager;
import com.fuhuadata.vo.CustomerEncyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 客户百科managerImpl
 * Created by intanswer on 2017/1/16.
 */
public class CustomerEncyclopediaManagerImpl implements CustomerEncyclopediaManager{
    private CustomerEncyclopediaDao customerEncyclopediaDao;

    @Autowired
    private CustomerBaseInfoDao customerBaseInfoDao;
    @Override
    @Transactional
    public CustomerEncyclopedia addCustomerEncyclopedia(CustomerEncyclopedia customerEncyclopedia) {

        //百科新增时判断是否是在原客户基础信息上新增百科，否则新增基本客户信息
        if(customerEncyclopedia.getCustomerId()==null||"".equals(customerEncyclopedia.getCustomerId())){
            CustomerBaseInfo customerBaseInfo  = new CustomerBaseInfo();
            customerBaseInfo.setCompanyType(customerEncyclopedia.getCompanyType());
            customerBaseInfo.setFullName(customerEncyclopedia.getFullName());
            customerBaseInfo.setShortName(customerEncyclopedia.getShortName());
            customerBaseInfo.setAreaId(customerEncyclopedia.getCustomerAreaId());
            customerBaseInfo.setArea(customerEncyclopedia.getCustomerArea());
            customerBaseInfo.setFullEnterpriseNature(customerEncyclopedia.getEnterpriseNature());
            customerBaseInfo.setCreateUserId(customerEncyclopedia.getCreateUserId());
            customerBaseInfo.setCreateUserName(customerEncyclopedia.getCreateUserName());
            customerBaseInfo.setLastmodifyUserId(customerEncyclopedia.getLastmodifyUserId());
            customerBaseInfo.setLastmodifyUserName(customerEncyclopedia.getLastmodifyUserName());
            if(customerEncyclopedia.getRegisteredFunds()!=null) {
                customerBaseInfo.setRegisteredFunds(customerEncyclopedia.getRegisteredFunds());
            }
            if(customerEncyclopedia.getRegisteredAddr()!=null) {
                customerBaseInfo.setRegisteredAddress(customerEncyclopedia.getRegisteredAddr());
            }
            if(customerEncyclopedia.getManagementScope()!=null) {
                customerBaseInfo.setManagementScope(customerEncyclopedia.getManagementScope());
            }
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            customerBaseInfo.setCreateTime(sdf.format(customerEncyclopedia.getCreateTime()));
            customerBaseInfo.setModifyTime(sdf.format(customerEncyclopedia.getModifyTime()));
            CustomerBaseInfo customerBaseInfoAdd = customerBaseInfoDao.addCustomerBaseInfo(customerBaseInfo);
            customerEncyclopedia.setCustomerId(customerBaseInfoAdd.getCustomerId());
            if(customerEncyclopedia.getEnterpriceNatures()!=null&&customerEncyclopedia.getEnterpriceNatures().length>0) {
                for(int i = 0;i<customerEncyclopedia.getEnterpriceNatures().length;i++){
                    customerEncyclopedia.getEnterpriceNatures()[i].setCustomerId(customerBaseInfoAdd.getCustomerId());
                }
                customerBaseInfoDao.batchAddNature(Arrays.asList(customerEncyclopedia.getEnterpriceNatures()));
            }
        }
        return customerEncyclopediaDao.addCustomerEncyclopedia(customerEncyclopedia);
    }

    /**
     * Dao层更新成功返回1
     * @param id
     * @param customerEncyclopedia
     * @return
     */
    @Override
    public boolean updateCustomerEncyclopediaById(String id, CustomerEncyclopedia customerEncyclopedia) {
        return customerEncyclopediaDao.updateCustomerEncyclopediaById(id,customerEncyclopedia)==1? true:false;
    }

    @Override
    public boolean deleteCustomerEncyclopediaById(String id) {
        return customerEncyclopediaDao.deleteCustomerEncyclopediaById(id) == 1 ? true:false;
    }

    @Override
    public CustomerEncyclopedia getCustomerEncyclopediaById(String id) {
        return customerEncyclopediaDao.getCustomerEncyclopediaById(id);
    }

    @Override
    public List<CustomerEncyVO> getCustomerEncyclopediaByQuery(CustomerEncyclopediaQuery customerEncyclopediaQuery) {
        return customerEncyclopediaDao.getCustomerEncyclopediaByQuery(customerEncyclopediaQuery);
    }

    @Override
    public Result<List<CustomerEncyclopedia>> getCustomerEncyclopediasByPage(CustomerEncyclopediaQuery customerEncyclopediaQuery) {
        Result<List<CustomerEncyclopedia>> result = new Result<List<CustomerEncyclopedia>>();
        //int totalItem = customerEncyclopediaDao.count(customerEncyclopediaQuery);
        //customerEncyclopediaQuery.setTotalItem(totalItem);
        //if(totalItem>0){
        //    result.addDefaultModel("CustomerEncyclopedias",customerEncyclopediaDao.getCustomerEncyclopediasByPage(customerEncyclopediaQuery));
        //}else{
        //    result.addDefaultModel("CustomerEncyclopedias",new ArrayList<CustomerEncyclopedia>());
        //}
        //result.setPageSize(customerEncyclopediaQuery.getPageSize());
        //result.setIndex(customerEncyclopediaQuery.getIndex());
        //result.setTotalItem(customerEncyclopediaQuery.getTotalItem());
        return result;
    }

    @Override
    public int count(CustomerEncyclopediaQuery customerEncyclopediaQuery) {
        return customerEncyclopediaDao.count(customerEncyclopediaQuery);
    }

    public CustomerEncyclopediaDao getCustomerEncyclopediaDao() {
        return customerEncyclopediaDao;
    }

    public void setCustomerEncyclopediaDao(CustomerEncyclopediaDao customerEncyclopediaDao){
        this.customerEncyclopediaDao = customerEncyclopediaDao;
    }
}

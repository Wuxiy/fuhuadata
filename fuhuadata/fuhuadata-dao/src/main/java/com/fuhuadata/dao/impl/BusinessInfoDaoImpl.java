package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.BusinessInfoDao;
import com.fuhuadata.domain.BusinessInfo;
import com.fuhuadata.domain.query.QueryBusinessInfo;
import com.fuhuadata.vo.BusinessInfoVO;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * 商机信息dao
 * Created by intanswer on 2017/3/24.
 */
public class BusinessInfoDaoImpl extends SqlMapClientTemplate implements BusinessInfoDao {

    public final static String ADD = "BUSINESSINFO.ADD";
    public final static String UPDATE="BUSINESSINFO.UPDATE";
    public final static String DELETE_BY_ID="BUSINESSINFO.DELETE-BY-ID";
    public final static String GET_BY_ID="BUSINESSINFO.GET-BY-ID";
    public final static String GET_BY_CUSTOMERID="BUSINESSINFO.GET-BY-CUSTOMERID";
    public final static String GET_BY_QUERY="BUSINESSINFO.GET-BY-QUERY";
    public final static String GET_PAGE="BUSINESSINFO.GET-PAGE";
    public final static String COUNT = "BUSINESSINFO.COUNT";

    @Override
    public BusinessInfo addBusinessInfo(BusinessInfo businessInfo) {
        this.insert(ADD, businessInfo);
        System.out.println(businessInfo.getDeadline());
        return businessInfo;
    }

    @Override
    public int updateBusinessInfoByBusinessId(BusinessInfo businessInfo) {
        return this.update(UPDATE,businessInfo);
    }

    @Override
    public int deleteBusinessInfoByBusinessId(String businessId) {
        return this.delete(DELETE_BY_ID,businessId);
    }

    @Override
    public BusinessInfo getBusinessInfoByBusinessId(String businessId) {
        return (BusinessInfo) this.queryForObject(GET_BY_ID,businessId);
    }

    @Override
    public List<BusinessInfo> getBusinessInfoByCustomerId(String customerId) {
        return this.queryForList(GET_BY_CUSTOMERID,customerId);
    }

    @Override
    public List<BusinessInfo> getBusinessInfoByQuery(QueryBusinessInfo queryBusinessInfo) {
        return this.queryForList(GET_BY_QUERY,queryBusinessInfo);
    }

    @Override
    public List<BusinessInfoVO> getBusinessInfoByPage(BusinessInfoVO businessInfoVO) {
        return this.queryForList(GET_PAGE,businessInfoVO);
    }

    public int count(QueryBusinessInfo queryBusinessInfo){
        return ((Integer) this.queryForObject(COUNT,queryBusinessInfo)).intValue();
    }
}

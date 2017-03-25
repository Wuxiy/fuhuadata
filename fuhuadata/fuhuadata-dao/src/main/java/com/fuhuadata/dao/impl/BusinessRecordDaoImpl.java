package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.BusinessRecordDao;
import com.fuhuadata.domain.BusinessRecord;
import com.fuhuadata.domain.query.QueryBusinessRecord;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by intanswer on 2017/3/25.
 */
public class BusinessRecordDaoImpl extends SqlMapClientTemplate implements BusinessRecordDao {

    public final static String ADD = "BUSINESSRECORD.ADD";
    public final static String UPDATE="BUSINESSRECORD.UPDATE";
    public final static String DELETE_BY_ID="BUSINESSRECORD.DELETE-BY-ID";
    public final static String GET_BY_ID="BUSINESSRECORD.GET-BY-ID";
    public final static String GET_BY_BUSINESSID="BUSINESSRECORD.GET-BY-BUSINESSID";
    public final static String GET_BY_QUERY="BUSINESSRECORD.GET-BY-QUERY";
    public final static String GET_PAGE="BUSINESSRECORD.GET-PAGE";
    public final static String COUNT = "BUSINESSRECORD.COUNT";
    @Override
    public BusinessRecord addBusinessRecord(BusinessRecord businessRecord) {
        businessRecord.setBusinessId((String )this.insert(ADD,businessRecord));
        return businessRecord;
    }

    @Override
    public int updateBusinessRecordById(BusinessRecord businessRecord) {
        return this.update(UPDATE,businessRecord);
    }

    @Override
    public int deleteBusinessRecordById(int id) {
        return this.delete(DELETE_BY_ID,id);
    }

    @Override
    public BusinessRecord getBusinessRecordById(int id) {
        return (BusinessRecord) this.queryForObject(GET_BY_ID,id);
    }

    @Override
    public List<BusinessRecord> getBusinessRecordByBusinessId(String businessId) {
        return this.queryForList(GET_BY_BUSINESSID,businessId);
    }

    @Override
    public List<BusinessRecord> getBusinessRecordByQuery(QueryBusinessRecord queryBusinessRecord) {
        return this.queryForList(GET_BY_QUERY,queryBusinessRecord);
    }
    public int count(QueryBusinessRecord queryBusinessRecord){
            return ((Integer) this.queryForObject(COUNT,queryBusinessRecord)).intValue();
    }

}

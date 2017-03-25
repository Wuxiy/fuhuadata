package com.fuhuadata.dao;

import com.fuhuadata.domain.BusinessRecord;
import com.fuhuadata.domain.query.QueryBusinessRecord;

import javax.management.Query;
import java.util.List;

/**
 * 商机跟进
 * Created by intanswer on 2017/3/25.
 */
public interface BusinessRecordDao {

    public BusinessRecord addBusinessRecord(BusinessRecord businessRecord);

    public int updateBusinessRecordById(BusinessRecord businessRecord);

    public int deleteBusinessRecordById(int id);

    public BusinessRecord getBusinessRecordById(int id);

    public List<BusinessRecord> getBusinessRecordByBusinessId(String businessId);

    public List<BusinessRecord> getBusinessRecordByQuery(QueryBusinessRecord queryBusinessRecord);

    public int count(QueryBusinessRecord queryBusinessRecord);
}

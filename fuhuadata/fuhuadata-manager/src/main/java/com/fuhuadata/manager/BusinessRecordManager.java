package com.fuhuadata.manager;

import com.fuhuadata.domain.BusinessRecord;
import com.fuhuadata.domain.query.QueryBusinessRecord;

import java.util.List;

/**
 * Created by intanswer on 2017/3/25.
 */
public interface BusinessRecordManager {
    public BusinessRecord addBusinessRecord(BusinessRecord businessRecord);

    public boolean updateBusinessRecordById(BusinessRecord businessRecord);

    public boolean deleteBusinessRecordById(int id);

    public BusinessRecord getBusinessRecordById(int id);

    public List<BusinessRecord> getBusinessRecordByBusinessId(String businessId);

    public List<BusinessRecord> getBusinessRecordByQuery(QueryBusinessRecord queryBusinessRecord);

    public int count(QueryBusinessRecord queryBusinessRecord);
}

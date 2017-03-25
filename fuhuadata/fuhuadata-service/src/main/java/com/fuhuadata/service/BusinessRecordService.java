package com.fuhuadata.service;

import com.fuhuadata.domain.BusinessRecord;
import com.fuhuadata.domain.query.QueryBusinessRecord;
import com.fuhuadata.domain.query.Result;

import java.util.List;

/**
 * Created by intanswer on 2017/3/25.
 */
public interface BusinessRecordService {

    public Result<BusinessRecord> addBusinessRecord(BusinessRecord businessRecord);

    public Result updateBusinessRecordById(BusinessRecord businessRecord);

    public Result deleteBusinessRecordById(int id);

    public Result<BusinessRecord> getBusinessRecordById(int id);

    public Result<List<BusinessRecord>> getBusinessRecordByBusinessId(String businessId);

    public Result<List<BusinessRecord>> getBusinessRecordByQuery(QueryBusinessRecord queryBusinessRecord);

    public Result<Integer> count(QueryBusinessRecord queryBusinessRecord);

}

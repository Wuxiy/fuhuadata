package com.fuhuadata.service.impl;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.RecordLinkmanManager;
import com.fuhuadata.service.RecordLinkmanService;
import com.fuhuadata.domain.query.QueryRecordLinkman;
import com.fuhuadata.domain.RecordLinkman;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.io.Serializable;

/**
 * @author wangbo
 * @date 2017-01-13 16:26:04
 */
public class RecordLinkmanServiceImpl implements RecordLinkmanService {
	
	@Resource
    private RecordLinkmanManager recordLinkmanManager;
    public Result<RecordLinkman> addRecordLinkman(RecordLinkman recordLinkman) {
		Result<RecordLinkman> result = new Result<RecordLinkman>();
		try {
			result.addDefaultModel(recordLinkmanManager.addRecordLinkman(recordLinkman));			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result updateRecordLinkmanById(int id, RecordLinkman recordLinkman) {
		Result result = new Result();
		try {
			result.setSuccess(recordLinkmanManager.updateRecordLinkmanById(id, recordLinkman));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result deleteRecordLinkmanById(int id) {
		Result result = new Result();
		try {
			result.setSuccess(recordLinkmanManager.deleteRecordLinkmanById(id));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }	
    	
    public Result<List<RecordLinkman>> getRecordLinkmansByQuery(QueryRecordLinkman queryRecordLinkman) {
		Result<List<RecordLinkman>> result = new Result<List<RecordLinkman>>();
		try {
			result.addDefaultModel("${!className}s", recordLinkmanManager.getRecordLinkmansByQuery(queryRecordLinkman));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<RecordLinkman> getRecordLinkmanById(int id) {
		Result<RecordLinkman> result = new Result<RecordLinkman>();
		try {		
		    RecordLinkman  recordLinkman = recordLinkmanManager.getRecordLinkmanById(id);
		    if(recordLinkman == null){
				result.setSimpleErrorMsg(0, "当前数据不存在，请重试");
			}else{
				result.addDefaultModel("RecordLinkman", recordLinkman);
			}
			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    

    public Result<List<RecordLinkman>> getRecordLinkmansByPage(QueryRecordLinkman queryRecordLinkman) {
		Result<List<RecordLinkman>> result = new Result<List<RecordLinkman>>();
		try {		
			result = recordLinkmanManager.getRecordLinkmansByPage(queryRecordLinkman);
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<Integer> count(QueryRecordLinkman queryRecordLinkman) {
		Result<Integer> result = new Result<Integer>();
		try {	
			result.addDefaultModel(recordLinkmanManager.count(queryRecordLinkman));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
	
}
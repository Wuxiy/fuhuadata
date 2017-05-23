package com.fuhuadata.manager.impl;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.dao.RecordLinkmanDao;
import com.fuhuadata.manager.RecordLinkmanManager;
import com.fuhuadata.domain.query.QueryRecordLinkman;
import com.fuhuadata.domain.RecordLinkman;
import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author wangbo
 * @date 2017-01-13 16:26:04
 */
public class RecordLinkmanManagerImpl implements RecordLinkmanManager {

	@Resource
    private RecordLinkmanDao recordLinkmanDao;
    

    public RecordLinkman addRecordLinkman(RecordLinkman recordLinkman) {
    	return recordLinkmanDao.addRecordLinkman(recordLinkman);
    }

	@Override
	public boolean addRecordLinkmen(List<RecordLinkman> recordLinkmen) {
		return recordLinkmanDao.addRecordLinkmen(recordLinkmen)==recordLinkmen.size()?true : false;
	}

	public boolean updateRecordLinkmanById(int id, RecordLinkman recordLinkman) {
    	return recordLinkmanDao.updateRecordLinkmanById(id, recordLinkman) == 1 ? true : false;
    }
    
	public List<RecordLinkman> getRecordLinkmansByQuery(QueryRecordLinkman queryRecordLinkman) {
		return recordLinkmanDao.getRecordLinkmansByQuery(queryRecordLinkman);
	}

	@Override
	public List<RecordLinkman> getRecordLinkmanByLinkmanId(String linkmanId) {
		return recordLinkmanDao.getRecordLinkmanByLinkmanId(linkmanId);
	}

	public boolean deleteRecordLinkmanById(int id) {
    	return recordLinkmanDao.deleteRecordLinkmanById(id) == 1 ? true : false;
    }

	@Override
	public boolean deleteRecordLinkmanByRecordId(int visitRecordId) {
		return recordLinkmanDao.deleteRecordLinkmanByRecordId(visitRecordId)>1 ? true : false;
	}


	public List<RecordLinkman> getAllRecordLinkmans() {
    	return recordLinkmanDao.getAllRecordLinkmans();
    }
    	
    public Result<List<RecordLinkman>> getRecordLinkmansByPage(QueryRecordLinkman queryRecordLinkman) {
		Result<List<RecordLinkman>> result = new Result<List<RecordLinkman>>();
		int totalItem = recordLinkmanDao.count(queryRecordLinkman);
		;
		if (totalItem > 0) {
			result.addDefaultModel("RecordLinkmans", recordLinkmanDao.getRecordLinkmansByPage(queryRecordLinkman));		
		} else {
			result.addDefaultModel("RecordLinkmans", new ArrayList<RecordLinkman>());
		}
		
		result.setPageSize(queryRecordLinkman.getPageSize());
		result.setIndex(queryRecordLinkman.getIndex());
		result.setTotalItem(totalItem);
		
		return result;
    }
    	
    	
    public RecordLinkman getRecordLinkmanById(int id) {
    	return recordLinkmanDao.getRecordLinkmanById(id);
    }
    

    public int count(QueryRecordLinkman queryRecordLinkman) {
    	return recordLinkmanDao.count(queryRecordLinkman);
    }
    
}
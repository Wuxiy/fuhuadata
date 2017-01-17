package com.fuhuadata.dao.impl;
import java.util.List;
import com.fuhuadata.dao.RecordLinkmanDao;
import com.fuhuadata.domain.query.QueryRecordLinkman;
import com.fuhuadata.domain.RecordLinkman;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import java.util.Map;
import java.io.Serializable;
/**
 * @author wangbo
 * @date 2017-01-13 16:26:04
 */
@SuppressWarnings("unchecked")
public class RecordLinkmanDaoImpl extends SqlMapClientTemplate implements RecordLinkmanDao {

    public static final String ADD = "RECORDLINKMAN.ADD";
    public static final String UPDATE = "RECORDLINKMAN.UPDATE";
    public static final String DELETE_BY_ID = "RECORDLINKMAN.DELETE-BY-ID";
    public static final String GET_ALL = "RECORDLINKMAN.GET-ALL";
    public static final String GET_BY_QUERY = "RECORDLINKMAN.GET-BY-QUERY";
    public static final String GET_BY_ID = "RECORDLINKMAN.GET-BY-ID";
    public static final String GET_PAGE = "RECORDLINKMAN.GET-PAGE";
    public static final String COUNT = "RECORDLINKMAN.COUNT";
    
    public RecordLinkman addRecordLinkman(RecordLinkman recordLinkman) {
		recordLinkman.setId((Integer) this.insert(ADD, recordLinkman));
    	return recordLinkman;
    }
    
    public int updateRecordLinkmanById(int id, RecordLinkman recordLinkman) {
    	recordLinkman.setId(id);
		return this.update(UPDATE, recordLinkman);
    }
    
    public int deleteRecordLinkmanById(int id) {
    	return this.update(DELETE_BY_ID, id);
    }
    
    public List<RecordLinkman> getAllRecordLinkmans() {
    	return this.queryForList(GET_ALL);
    }
    	
    public List<RecordLinkman> getRecordLinkmansByQuery(QueryRecordLinkman queryRecordLinkman) {
    	return this.queryForList(GET_BY_QUERY, queryRecordLinkman);
    }
    	
    public RecordLinkman getRecordLinkmanById(int id) {
    	return (RecordLinkman) this.queryForObject(GET_BY_ID, id);
    }
    
    public List<RecordLinkman> getRecordLinkmansByPage(QueryRecordLinkman queryRecordLinkman) {
    	return this.queryForList(GET_PAGE, queryRecordLinkman);
    }
    	
    public int count(QueryRecordLinkman queryRecordLinkman) {
    	return ((Integer) this.queryForObject(COUNT, queryRecordLinkman)).intValue();
    }
}
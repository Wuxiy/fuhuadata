package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.PackingArchivesDao;
import com.fuhuadata.domain.PackingArchives;
import com.fuhuadata.domain.query.PackingArchivesQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.beans.IntrospectionException;
import java.util.List;

/**
 * 包材档案DaoImpl
 * Created by intanswer on 2017/1/23.
 */
public class PackingArchivesDaoImpl extends SqlMapClientTemplate implements PackingArchivesDao {
    public static final String ADD = "PACKINGARCHIVES.ADD";
    public static final String UPDATE = "PACKINGARCHIVES.UPDATE";
    public static final String DELETE_BY_ID = "PACKINGARCHIVES.DELETE-BY-ID";
    public static final String GET_ALL = "PACKINGARCHIVES.GET-ALL";
    public static final String GET_BY_QUERY = "PACKINGARCHIVES.GET-BY-QUERY";
    public static final String GET_BY_ID = "PACKINGARCHIVES.GET-BY-ID";
    public static final String GET_BY_PID="PACKINGARCHIVES.GET-BY-PID";
    public static final String GET_PAGE = "PACKINGARCHIVES.GET-PAGE";
    public static final String COUNT = "PACKINGARCHIVES.COUNT";
    @Override
    public PackingArchives addPackingArchives(PackingArchives packingArchives) {
        packingArchives.setPackingId((Integer) this.insert(ADD,packingArchives));
        return packingArchives;
    }

    @Override
    public int updatePackingArchivesById(int id, PackingArchives packingArchives) {
        packingArchives.setPackingId(id);
        return this.update(UPDATE,packingArchives);
    }

    @Override
    public int deletePackingArchivesById(int id) {
        return this.delete(DELETE_BY_ID,id);
    }

    @Override
    public List<PackingArchives> getAllPackingArchives() {
        return this.queryForList(GET_ALL);
    }

    @Override
    public List<PackingArchives> getPackingArchivesByQuery(PackingArchivesQuery packingArchivesQuery) {
        return this.queryForList(GET_BY_QUERY,packingArchivesQuery);
    }

    @Override
    public PackingArchives getPackingArchivesById(int id) {
        return (PackingArchives) this.queryForObject(GET_BY_ID,id);
    }

    @Override
    public List<PackingArchives> getPackingArchivesByPId(int id) {
        return this.queryForList(GET_BY_PID,id);
    }

    @Override
    public List<PackingArchives> getPackingArchivesByPage(PackingArchivesQuery packingArchivesQuery) {
        return this.queryForList(GET_PAGE,packingArchivesQuery);
    }

    @Override
    public int count(PackingArchivesQuery packingArchivesQuery) {
        return ((Integer) this.queryForObject(COUNT,packingArchivesQuery)).intValue();
    }
}

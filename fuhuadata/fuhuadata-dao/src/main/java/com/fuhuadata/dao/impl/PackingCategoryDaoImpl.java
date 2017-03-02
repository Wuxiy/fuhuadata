package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.PackingCategoryDao;
import com.fuhuadata.domain.PackingCategory;
import com.fuhuadata.vo.PackingCategoryVO;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by intanswer on 2017/2/23.
 */
public class PackingCategoryDaoImpl extends SqlMapClientTemplate implements PackingCategoryDao {
    private static final String ADD="PACKINGCATEGORY.ADD";
    private static final String UPDATE="PACKINGCATEGORY.UPDATE";
    private static final String DELETE_BY_ID="PACKINGCATEGORY.DELETE-BY-ID";
    private static final String GET_ALL="PACKINGCATEGORY.GET-ALL";
    private static final String GET_BY_PID="PACKINGCATEGORY.GET-BY-PID";
    private static final String GET_BY_ID="PACKINGCATEGORY.GET-BY-ID";
    private static final String GET_BY_LEVEL="PACKINGCATEGORY.GET-BY-LEVEL";
    @Override
    public PackingCategory addPackingCategory(PackingCategory packingCategory) {
        packingCategory.setCategoryId((Integer)this.insert(ADD,packingCategory));
        return packingCategory;
    }

    @Override
    public int updatePackingCategoryById(int id, PackingCategory packingCategory) {
        packingCategory.setCategoryId(id);
        return this.update(UPDATE,packingCategory);
    }

    @Override
    public int deletePackingCategoryById(int id) {
        return this.delete(DELETE_BY_ID,id);
    }

    @Override
    public List<PackingCategory> getAll() {
        return this.queryForList(GET_ALL);
    }

    @Override
    public List<PackingCategoryVO> getAllByLevel() {
        return this.queryForList(GET_BY_LEVEL);
    }

    @Override
    public List<PackingCategory> getPackingCategoryByParentId(int id) {
        return this.queryForList(GET_BY_PID,id);
    }

    @Override
    public PackingCategory getPackingCategoryById(int id) {
        return (PackingCategory) this.queryForObject(GET_BY_ID,id);
    }
}

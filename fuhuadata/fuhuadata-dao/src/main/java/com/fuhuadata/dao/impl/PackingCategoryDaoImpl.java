package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.PackingCategoryDao;
import com.fuhuadata.domain.PackingCategory;
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
}

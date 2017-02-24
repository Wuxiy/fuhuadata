package com.fuhuadata.dao;

import com.fuhuadata.domain.PackingCategory;

import java.util.List;

/**
 * 包材dao
 * Created by intanswer on 2017/2/23.
 */
public interface PackingCategoryDao {
    public PackingCategory addPackingCategory(PackingCategory packingCategory);

    public int updatePackingCategoryById(int id,PackingCategory packingCategory);

    public int deletePackingCategoryById(int id);

    /**
     * 获取包材原数据
     * @return
     */
    public List<PackingCategory> getAll();


}

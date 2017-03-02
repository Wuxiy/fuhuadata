package com.fuhuadata.dao;

import com.fuhuadata.domain.PackingCategory;
import com.fuhuadata.vo.PackingCategoryVO;

import java.util.List;

/**
 * 包材分类树dao
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

    public List<PackingCategoryVO> getAllByLevel();

    public List<PackingCategory> getPackingCategoryByParentId(int id);

    public PackingCategory getPackingCategoryById(int id);


}

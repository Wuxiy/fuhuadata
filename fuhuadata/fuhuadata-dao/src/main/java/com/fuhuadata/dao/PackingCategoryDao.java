package com.fuhuadata.dao;

import com.fuhuadata.domain.PackingCategory;
import com.fuhuadata.vo.CategoryVO;

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

    /**
     *parentId 为null时查询所有数据 为1时只查询主材数据，为2时查询外包装数据 为3查询辅材数据
     * @param parentIds 1：主材 2：外包装 3：辅材,查询多种材料时逗号分隔，例如2,3表示只查询外包装和辅材
     * @return
     */
    public List<CategoryVO> getAllByLevel(String parentIds);



    public List<PackingCategory> getPackingCategoryByParentId(int id);

    public PackingCategory getPackingCategoryById(int id);


}

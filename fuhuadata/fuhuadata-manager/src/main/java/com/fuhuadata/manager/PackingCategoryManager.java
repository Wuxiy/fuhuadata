package com.fuhuadata.manager;

import com.fuhuadata.domain.PackingCategory;
import com.fuhuadata.vo.PackingCategoryVO;

import java.util.List;

/**
 * 包材树manager
 * Created by intanswer on 2017/2/23.
 */
public interface PackingCategoryManager {

    public PackingCategory addPackingCategory(PackingCategory packingCategory);

    public boolean updatePackingCategoryById(int id,PackingCategory packingCategory);

    public boolean deletePackingCategoryById(int id);

    public List<PackingCategory> getAll();

    public List<PackingCategory> getPackingCategoryByPId(int id);

    public List<PackingCategoryVO> getAllByLevel(String parentIds);

    public PackingCategory getPackingCategoryById(int id);

}

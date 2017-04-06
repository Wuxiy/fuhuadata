package com.fuhuadata.service;

import com.fuhuadata.domain.PackingCategory;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.vo.CategoryTree;

import java.util.List;

/**
 * 包材目录树service
 * Created by intanswer on 2017/2/23.
 */
public interface PackingCategoryService {
    public Result addPackingCategory(PackingCategory packingCategory);

    public Result updatePackingCategoryById(int id,PackingCategory packingCategory);

    public Result deltePackingCategoryById(int id);

    public Result<List<PackingCategory>> getAll();

    public Result<List<CategoryTree>> getAllByTree(String parentIds);

}

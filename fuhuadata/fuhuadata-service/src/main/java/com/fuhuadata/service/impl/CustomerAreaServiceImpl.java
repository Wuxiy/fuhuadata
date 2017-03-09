package com.fuhuadata.service.impl;

import com.fuhuadata.domain.CustomerArea;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.CustomerAreaManager;
import com.fuhuadata.service.CustomerAreaService;
import com.fuhuadata.vo.CategoryTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hexingfu on 2017/3/9.
 */
@Service
public class CustomerAreaServiceImpl implements CustomerAreaService{

    @Autowired
    private CustomerAreaManager customerAreaManager;

    @Override
    public Result<List<CategoryTree>> getAllCustomerAreaList() {
        List<CustomerArea> area_list =  customerAreaManager.getAllCustomerAreaList();
        Map<String,CategoryTree> tree_map = new HashMap<String,CategoryTree>();
        for(CustomerArea area:area_list){
            CategoryTree current_child = new CategoryTree();
            current_child.setCname(area.getAreaName());
            current_child.setCid(area.getAreaId());
            current_child.setPid(area.getAreaClassId());
            CategoryTree parent = tree_map.get(area.getAreaClassId());
            if(parent == null){
                parent = new CategoryTree();
                parent.setCid(area.getAreaClassId());
                parent.setCname(area.getAreaClassName());
                parent.setPid("0");
            }
            parent.addChildNode(current_child);
            tree_map.put(parent.getCid(),parent);
        }

        List<CategoryTree> list =  new ArrayList<CategoryTree>(tree_map.values());
        Result<List<CategoryTree>> result = new Result<List<CategoryTree>>();
        result.addDefaultModel(list);
        return result;
    }
}

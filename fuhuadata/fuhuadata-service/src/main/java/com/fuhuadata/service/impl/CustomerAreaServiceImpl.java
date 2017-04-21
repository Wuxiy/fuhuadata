package com.fuhuadata.service.impl;

import com.fuhuadata.domain.CustomerArea;
import com.fuhuadata.domain.Organization;
import com.fuhuadata.domain.query.QueryOrganization;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.CustomerAreaManager;
import com.fuhuadata.service.CustomerAreaService;
import com.fuhuadata.util.StringUtil;
import com.fuhuadata.vo.CategoryTree;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by hexingfu on 2017/3/9.
 */
@Service
public class CustomerAreaServiceImpl implements CustomerAreaService{

    @Autowired
    private CustomerAreaManager customerAreaManager;


    public Result<List<CustomerArea>> getAllCustomerAreaList(String id) {
        if(StringUtils.isBlank(id)){
            id = "~";
        }
        List<CustomerArea> area_list =  customerAreaManager.getAllCustomerAreaList(id);
        Result<List<CustomerArea>> result = new Result<List<CustomerArea>>();
        result.addDefaultModel(area_list);
        return result;
       /* //将组织列表转换为组织树map对象
        Map<String,CategoryTree> map = listToTreeMap(area_list);
        //给每个树对象添加子节点
        for(CustomerArea o:area_list){
            CategoryTree p_ct = map.get(o.getPkFatherarea());
            if(p_ct==null){
                continue;
            }
            CategoryTree ct = map.get(o.getPkAreacl());
            p_ct.addChildNode(ct);
        }

        //移除map中已被添加到父节点的子节点对象
        //首先查找需要被从map中移除的key
        Iterator<Map.Entry<String,CategoryTree>> it = map.entrySet().iterator();
        List<String> del_list = new ArrayList<String>();
        while(it.hasNext()){
            List<CategoryTree> clist = it.next().getValue().getNodes();
            if(clist==null){
                continue;
            }
            for(CategoryTree c:clist){
                del_list.add(c.getCid());
            }
        }
        for(String s:del_list){
            map.remove(s);
        }*/
       /* Result<List<CategoryTree>> result = new Result<List<CategoryTree>>();
        result.addDefaultModel(new ArrayList<CategoryTree>(map.values()));
        return result;*/
    }
    private Map<String,CategoryTree> listToTreeMap(List<CustomerArea> list){
        Map<String,CategoryTree> map = new HashMap<String,CategoryTree>();
        for(CustomerArea o:list){
            CategoryTree ct = new CategoryTree();
            ct.setCname(o.getName());
            ct.setPid(o.getPkFatherarea());
            ct.setCid(o.getPkAreacl());
            map.put(o.getPkAreacl(),ct);
        }
        return map;
    }





  /*  @Override
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
        CategoryTree root = new CategoryTree();
        root.setCid("0");
        root.setCname("全部");
        root.setNodes(list);
        List<CategoryTree> result_list = new ArrayList<CategoryTree>();
        result_list.add(root);
        Result<List<CategoryTree>> result = new Result<List<CategoryTree>>();
        result.addDefaultModel(result_list);
        return result;
    }*/
}

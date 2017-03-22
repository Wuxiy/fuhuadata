package com.fuhuadata.service.impl;

import com.fuhuadata.dao.OrganizationDao;
import com.fuhuadata.domain.Organization;
import com.fuhuadata.domain.query.QueryOrganization;
import com.fuhuadata.vo.CategoryTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by hexingfu on 2017/3/22.
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationDao organizationDao;

    @Override
    public List<Organization> getOrganizationListByQuery(QueryOrganization queryOrganization) {
        return organizationDao.getOrganizationListByQuery(queryOrganization);
    }

    @Override
    public List<CategoryTree> getOrganizationTreeByQuery(QueryOrganization queryOrganization) {
        List<Organization> organizationList = this.getOrganizationListByQuery(queryOrganization);
        //将组织列表转换为组织树map对象
        Map<String,CategoryTree> map = listToTreeMap(organizationList);
        //给每个树对象添加子节点
        for(Organization o:organizationList){
            CategoryTree p_ct = map.get(o.getParentId()+"");
            if(p_ct==null){
                continue;
            }
            CategoryTree ct = map.get(o.getOrgId()+"");
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
        }
        return new ArrayList<CategoryTree>(map.values());
    }
    private Map<String,CategoryTree> listToTreeMap(List<Organization> list){
        Map<String,CategoryTree> map = new HashMap<String,CategoryTree>();
        for(Organization o:list){
            CategoryTree ct = new CategoryTree();
            ct.setCname(o.getName());
            ct.setPid(o.getParentId()+"");
            ct.setCid(o.getOrgId()+"");
            map.put(o.getOrgId()+"",ct);
        }
        return map;
    }
}

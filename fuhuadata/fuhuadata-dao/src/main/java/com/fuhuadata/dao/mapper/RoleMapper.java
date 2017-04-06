package com.fuhuadata.dao.mapper;

import com.fuhuadata.domain.mybatis.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role, Integer> {

    Role getRole(@Param("id") Integer id);

    /**
     * 删除自身和子节点
     * @param parentId
     * @param parents 该节点作为父节点的字符串
     */
    void deleteSelfAndChildren(@Param("parentId") Integer parentId, @Param("parents") String parents);

    int countNextIndex(@Param("parentId") Integer parentId);

    int updateChildrenParentIds(@Param("newParentIds") String newParentIds,
                                @Param("oldParentIds") String oldParentIds);

    /**
     * 获取自己和自己后面的兄弟
     *
     * @param parentId
     * @param weight
     * @return
     */
    List<Role> listSelfAndNextSiblings(@Param("parentId") Integer parentId, @Param("weight") int weight);
}
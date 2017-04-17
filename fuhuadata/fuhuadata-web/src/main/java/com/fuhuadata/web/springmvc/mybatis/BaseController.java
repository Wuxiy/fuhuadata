package com.fuhuadata.web.springmvc.mybatis;

import com.fuhuadata.domain.mybatis.BaseEntity;
import com.fuhuadata.util.ReflectUtils;
import com.fuhuadata.web.springmvc.permission.PermissionList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>User: wangjie
 * <p>Date: 3/24/2017
 */
public abstract class BaseController<E extends BaseEntity<ID>, ID extends Serializable> {

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 实体类型
     */
    protected final Class<E> entityClass;

    protected PermissionList permissionList = null;

    public BaseController() {
        this.entityClass = ReflectUtils.findParameterizedType(getClass(), 0);
    }

    protected E newEntity() {
        try {
            return entityClass.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException("can not instantiated entity : " + this.entityClass, e);
        }
    }

    /**
     * 权限前缀：如sys:user
     * 则生成的新增权限为 sys:user:create
     */
    public void setResourceIdentity(String resourceIdentity) {
        if (!StringUtils.isEmpty(resourceIdentity)) {
            permissionList = PermissionList.newPermissionList(resourceIdentity);
        }
    }

    //put this in your Controller
    //(if you have a superclass for your controllers
    //and want to use the same date format throughout the app, put it there)
    @InitBinder
    private void dateBinder(WebDataBinder binder) {
        //The date format to parse or output your dates
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //Create a new CustomDateEditor
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        //Register it as custom editor for the Date type
        binder.registerCustomEditor(Date.class, editor);
    }

}

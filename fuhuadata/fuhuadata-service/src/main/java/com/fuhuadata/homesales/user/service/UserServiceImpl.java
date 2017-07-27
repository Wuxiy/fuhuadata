package com.fuhuadata.homesales.user.service;

import com.fuhuadata.domain.mybatis.UserAccount;
import com.fuhuadata.homesales.user.domain.User;
import com.fuhuadata.service.mybatis.UserAreaService;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * <p>User: wangjie
 * <p>Date: 7/26/2017
 */
@Service("com.fuhuadata.homesales.user.service.UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    com.fuhuadata.service.mybatis.UserService userService;

    @Resource
    AreaService areaService;

    @Resource
    UserAreaService userAreaService;

    private UserService currentProxy() {
        return (UserService) AopContext.currentProxy();
    }

    @Override
    public User get(String userId) {

        if (StringUtils.isEmpty(userId)) {
            return null;
        }

        User user = userService.getUserOptByCode(userId)
                .map(User::of)
                .orElse(null);

        // 设置是否是领导
        if (user != null) {
            if (isLead(user)) {
                user.setUserPosition(1);
            } else {
                user.setUserPosition(2);
            }
        }

        return user;
    }

    @Override
    public List<User> listSubordinates(String userId) {

        if (StringUtils.isEmpty(userId)) {
            return Collections.emptyList();
        }

        List<User> users = Lists.newArrayList();

        List<String> areaIds = userAreaService.listAreaIdsByUserId(userId);
        // 查询子节点下的人员，则为下属
        areaIds.forEach(areaId -> areaService.listChildren(areaId)
                .forEach(child -> users.addAll(listAllByAreaId(String.valueOf(child.getId())))));

        return users;
    }

    @Override
    public List<User> listByAreaId(String areaId) {

        if (StringUtils.isEmpty(areaId)) {
            return Collections.emptyList();
        }

        List<String> userIds = userAreaService.listUserIdsByAreaId(areaId);
        List<UserAccount> userAccounts = userService.listUserByUserCodes(userIds);

        return userAccounts.stream()
                .map(User::of)
                .collect(toList());
    }

    @Override
    public List<User> listAllByAreaId(String areaId) {

        if (StringUtils.isEmpty(areaId)) {
            return Collections.emptyList();
        }

        List<User> users = Lists.newArrayList();

        // 获取本地区的人员
        List<User> userOfArea = listByAreaId(areaId);
        users.addAll(userOfArea);

        // 递归获取子节点下的人员
        areaService.listChildren(areaId)
                .forEach(child -> users.addAll(listAllByAreaId(String.valueOf(child.getId()))));

        return users;
    }

    @Override
    public boolean isLead(User user) {

        List<String> areaIds = userAreaService.listAreaIdsByUserId(user.getCode());
        for (String areaId : areaIds) {
            if (!areaService.listChildren(areaId).isEmpty()) {
                return true;
            }
        }

        return false;
    }
}

package com.uic.service.impl;

import com.uic.dao.UserMapper;
import com.uic.dao.RoleMapper;
import com.uic.pojo.User;
import com.uic.pojo.Role;
import com.uic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    /**
     * 根据登录id查找用户
     */
    @Override
    public User findUserByUserId(String userId) throws Exception {
        return userMapper.findUserByUserId(userId);
    }

    /**
     * 根据角色id查找角色信息
     */
    @Override
    public Role findRoleByRoleId(String roleId) throws Exception {
        return roleMapper.findRoleByRoleId(roleId);
    }

}

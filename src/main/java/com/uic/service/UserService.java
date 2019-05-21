package com.uic.service;

import com.uic.pojo.User;
import com.uic.pojo.Role;
public interface UserService {
    /**
     * 根据登录id查找用户
     */
    public User findUserByUserId(String userId)throws Exception;

    /**
     * 根据角色id查找角色信息
     */
    public Role findRoleByRoleId(String roleId)throws Exception;

}

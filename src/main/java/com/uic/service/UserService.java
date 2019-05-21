package com.uic.service;

import com.uic.pojo.User;
import com.uic.pojo.Role;

/**
 * 用户管理ervice
 */
public interface UserService {
    /**
     * 根据登录id查找用户
     */
    public User findUserByUserId(String userId)throws Exception;

    /**
     * 根据角色id查找角色信息
     */
    public Role findRoleByRoleId(String roleId)throws Exception;

    /**
     * 根据用户id修改用户密码
     */
    public void updateUserPasswordByUserId(String password,String userId)throws Exception;

}

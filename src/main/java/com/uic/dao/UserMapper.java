package com.uic.dao;
import com.uic.pojo.User;
import com.uic.pojo.Role;

import java.util.List;

/**
 * 用户管理
 */
public interface UserMapper {
    /**
     * 遍历所有用户
     * @return
     * @throws Exception
     */
    public List<User> queryUser(User user)throws Exception;

    /**
     * 根据登录id查找正常使用的用户
     * @param userId
     * @return
     * @throws Exception
     */
    public User findUserByUserId(String userId)throws Exception;

    /**
     * 根据角色id查找角色信息
     * @param roleId
     * @return
     * @throws Exception
     */
    public Role findRoleByRoleId(String roleId)throws Exception;

    /**
     * 添加用户信息
     * @param user
     * @throws Exception
     */
    public void insertUser(User user)throws Exception;

    /**
     * 存在则插入，不存在则更新用户信息
     * @param user
     * @throws Exception
     */
    public void insertOrUpdateUser(User user)throws Exception;


    /**
     * 根据用户id修改用户密码
     * @param password
     * @throws Exception
     */
    public void updateUserPasswordByUserId(String password,String userId)throws Exception;

    /**
     * 根据用户id逻辑删除用户
     * @param userId
     * @throws Exception
     */
    public void deleteUserByUserId(String userId) throws Exception;

    /**
     * 根据用户Id前缀真正的删除用户
     * @param id
     * @throws Exception
     */
    public void deleteUserTrue(String id)throws Exception;
}

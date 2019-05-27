package com.uic.dao;

import com.uic.pojo.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 用户管理
 */
public interface UserMapper {
    /**
     * 遍历所有用户
     */
    public List<User> queryUser(User user)throws Exception;

    /**
     * 根据登录id查找正常使用的用户
     */
    public User findUserByUserId(String userId)throws Exception;

    /**
     * 添加用户信息
     */
    public void insertUser(User user)throws Exception;

    /**
     * 存在则插入，不存在则更新用户信息
     */
    public void insertOrUpdateUser(User user)throws Exception;

    /**
     * 根据用户id修改用户密码
     */
    public void updateUserPasswordByUserId(User user)throws Exception;

    /**
     * 根据用户id逻辑删除用户
     */
    public void deleteUserByUserId(String userId) throws Exception;

    /**
     * 根据用户Id前缀真正的删除用户
     */
    public void deleteUserTrue(String id)throws Exception;

    List<User> selectUser(User user);
}

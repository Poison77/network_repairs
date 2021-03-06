package com.uic.service;

import com.uic.pojo.User;
import com.uic.pojo.Role;
import com.uic.pojo.Worker;

import java.util.List;

/**
 * 用户管理Service
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
//    public void updateUserPasswordByUserId(String password,String userId)throws Exception;
    public void updateUserPasswordByUserId(User user)throws Exception;


    /**
     * 根据职工id查询职工信息
     */
    public Worker findWorkerByWorkerId(String workerId)throws Exception;

    /**
     * 插入职工信息
     */
    public void insertWorker(Worker worker)throws Exception;

    /**
     * 遍历所有用户
     */
    public List<User> queryUser(User user)throws Exception;

    /**
     * 职工修改个人信息
     */
    public void updateWorkerByWorkerId(Worker worker)throws Exception;

    /**
     * 查询所有职工信息
     */
    public List<Worker> queryWorker()throws Exception;

    /**
     * 存在则插入，不存在则更新用户信息
     * @param user
     * @throws Exception
     */
    public void insertOrUpdateUser(User user)throws Exception;

    /**
     * 逻辑删除用户信息
     */
    public void deleteUser(String userId)throws Exception;

    /**
     * 逻辑删除职工信息
     */
    public void deleteWorker(String workerId)throws Exception;

    List<User> selectUser(User user);

}

package com.uic.service.impl;

import com.uic.dao.RoleMapper;
import com.uic.dao.UserMapper;
import com.uic.dao.WorkerMapper;
import com.uic.pojo.Role;
import com.uic.pojo.User;
import com.uic.pojo.Worker;
import com.uic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private WorkerMapper workerMapper;

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

    /**
     * 根据用户id修改用户密码
    /*
    @Override
    public void updateUserPasswordByUserId(String password, String userId) throws Exception {
        System.out.println("UserService " + password + userId);
        userMapper.updateUserPasswordByUserId(password, userId);
    }*/
    @Override
    public void updateUserPasswordByUserId(User user) throws Exception {
        userMapper.updateUserPasswordByUserId(user);
    }

    /**
     * 根据职工id查询职工信息
     */
    @Override
    public Worker findWorkerByWorkerId(String workerId) throws Exception {
        return workerMapper.findWorkerByWorkerId(workerId);
    }

    /**
     * 遍历所有用户
     */
    @Override
    public List<User> queryUser(User user) throws Exception {
        return userMapper.queryUser(user);
    }

    /**
     * 职工修改个人信息
     */
    @Override
    public void updateWorkerByWorkerId(Worker worker) throws Exception {
        workerMapper.updateWorkerByWorkerId(worker);
    }

    /**
     * 查询所有职工信息
     */
    @Override
    public List<Worker> queryWorker() throws Exception {
        return workerMapper.queryWorker();
    }

    /**
     * 存在则插入，不存在则更新用户信息
     * @param user
     * @throws Exception
     */
    @Override
    public void insertOrUpdateUser(User user) throws Exception {
        userMapper.insertOrUpdateUser(user);
    }

    /**
     * 插入职工信息
     * @param worker
     * @throws Exception
     */
    @Override
    public void insertWorker(Worker worker) throws Exception {
        workerMapper.insertOrUpdateWorker(worker);
    }

    /**
     * 逻辑删除用户信息
     */
    @Override
    public void deleteUser(String userId) throws Exception {
        userMapper.deleteUserByUserId(userId);
    }

    /**
     * 逻辑删除职工信息
     */
    @Override
    public void deleteWorker(String workerId) throws Exception {
        workerMapper.deleteWorkerByWorkerId(workerId);
    }

    @Override
    public List<User> selectUser(User user) {
        return userMapper.selectUser(user);
    }

}

package com.uic.dao;
import com.uic.pojo.User;

public interface UserMapper {
    /**
     * 根据登录id查找正常使用的用户
     */
    User findUserByUserId(String userId)throws Exception;
}

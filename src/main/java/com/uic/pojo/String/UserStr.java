package com.uic.pojo.String;

import com.uic.pojo.User;

/**
 * User类的str格式
 * 全部类型改为String ,方便前后端传值
 * 主要是为了时间在前端的显示格式
 */
public class UserStr extends User{
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "UserStr{" +
                "roleName='" + roleName + '\'' +
                ", id=" + getId() +
                ", userId='" + getUserId() + '\'' +
                ", userPassword='" + getUserPassword() + '\'' +
                ", userRoleId='" + getUserRoleId() + '\'' +
                ", flag=" + getFlag() +
                '}';
    }
}

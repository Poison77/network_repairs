package com.uic.dao;
import com.uic.pojo.Role;

public interface RoleMapper {
    /**
     * 根据角色id查找角色信息
     */
    Role findRoleByRoleId(String roleId)throws Exception;

}

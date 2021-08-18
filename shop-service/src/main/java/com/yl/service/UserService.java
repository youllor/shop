package com.yl.service;

import com.yl.bo.UserBO;
import com.yl.pojo.Stu;
import com.yl.pojo.Users;

/**
 * @author gzf
 * @date 2021/8/17 20:28
 */
public interface UserService {
    /**
     * 判断用户名是否存在
     * @param username
     */
    public boolean queryUsernameIsExist(String username);

    /**
     * 创建用户
     */
    public Users createUser(UserBO userBO);
}

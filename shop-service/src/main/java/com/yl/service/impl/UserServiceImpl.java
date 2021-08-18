package com.yl.service.impl;

import com.yl.bo.UserBO;
import com.yl.enums.ESex;
import com.yl.mapper.UsersMapper;
import com.yl.pojo.Users;
import com.yl.service.UserService;
import com.yl.utils.DateUtil;
import com.yl.utils.MD5Utils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author gzf
 * @date 2021/8/17 20:30
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UsersMapper usersMapper;

    @Autowired
    private Sid sid;
    private static final String  USER_FACE = "http://pic.616pic.com/ys_bnew_img/00/06/27/TWk2P5YJ5k.jpg";

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameIsExist(String username) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();

        userCriteria.andEqualTo("username",username);

        Users result = usersMapper.selectOneByExample(userExample);

        return result != null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Users createUser(UserBO userBO) {
        String userId = sid.nextShort();
        Users user = new Users();
        user.setId(userId);
        user.setUsername(userBO.getUsername());
        try {
            user.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //默认用户昵称同用户名
        user.setNickname(userBO.getUsername());
        //默认头像
        user.setFace(USER_FACE);
        //默认生日
        user.setBirthday(DateUtil.stringToDate("1900-01-01"));
        //默认性别为保密
        user.setSex(ESex.secret.code);
        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());

        usersMapper.insert(user);
        return user;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users queryUserForLogin(String username, String password) {

        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();

        userCriteria.andEqualTo("username", username);
        userCriteria.andEqualTo("password", password);

        return usersMapper.selectOneByExample(userExample);
    }
}

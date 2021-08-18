package com.yl.service.impl;

import com.yl.mapper.StuMapper;
import com.yl.pojo.Stu;
import com.yl.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author gzf
 * @date 2021/8/17 20:30
 */
@Service
public class StuServiceImpl implements StuService {
    @Resource
    private StuMapper stuMapper;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Stu getStuInfo(Integer id) {
        return stuMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveStu() {

    }

    @Override
    public void updateStu(Integer id) {

    }

    @Override
    public void deleteStu(Integer id) {

    }
}

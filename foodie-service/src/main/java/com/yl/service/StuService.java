package com.yl.service;

import com.yl.pojo.Stu;

/**
 * @author gzf
 * @date 2021/8/17 20:28
 */
public interface StuService {

    public Stu getStuInfo(Integer id);

    public void saveStu();

    public void updateStu(Integer id);

    public void deleteStu(Integer id);
}

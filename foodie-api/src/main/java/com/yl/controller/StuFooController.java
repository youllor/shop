package com.yl.controller;

import com.yl.mapper.StuMapper;
import com.yl.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gzf
 * @date 2021/8/17 20:32
 */
@RestController
public class StuFooController {
    @Autowired
    private StuService stuService;
    @GetMapping("/getStu")
    public Object getStu(Integer id){
        return stuService.getStuInfo(id);
    }
}

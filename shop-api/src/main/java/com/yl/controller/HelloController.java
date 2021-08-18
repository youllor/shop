package com.yl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author gzf
 * @date 2021/8/17 18:23
 */
@RestController
@ApiIgnore
public class HelloController {
    @GetMapping("/hello")
    public Object hello(){
        return "Hello World~";
    }
}

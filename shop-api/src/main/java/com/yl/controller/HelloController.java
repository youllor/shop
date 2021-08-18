package com.yl.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import org.slf4j.Logger;

/**
 * @author gzf
 * @date 2021/8/17 18:23
 */
@RestController
@ApiIgnore
public class HelloController {
    final static Logger logger=LoggerFactory.getLogger(HelloController.class);
    @GetMapping("/hello")
    public Object hello(){
        logger.debug("hello");
        logger.info("hello");
        logger.warn("hello");
        logger.error("hello");
        return "Hello World~";
    }
}

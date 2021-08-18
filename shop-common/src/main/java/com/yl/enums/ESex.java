package com.yl.enums;

/**
 * @author gzf
 * @date 2021/8/17 23:16
 * 性别 枚举
 */
public enum ESex {
    woman(0,"女"),
    man(1,"男"),
    secret(2,"保密");

    public final Integer code;
    public final String value;

    ESex(Integer code,String value){
        this.code = code;
        this.value = value;
    }

}

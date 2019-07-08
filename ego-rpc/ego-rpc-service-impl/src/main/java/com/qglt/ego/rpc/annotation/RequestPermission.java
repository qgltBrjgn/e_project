package com.qglt.ego.rpc.annotation;


import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;


@Target({ElementType.METHOD})//在方法上加上权限注解
@Retention(RetentionPolicy.RUNTIME)//当运行时反射性的读取
@Documented//在类文件里记录
@Mapping
public @interface RequestPermission {//自定义类名



    String redisIn() default "";//自定义方法名
}
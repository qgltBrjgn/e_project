package com.qglt.ego.rpc.aop;

import com.qglt.ego.rpc.mapper.db.dao.TbItemCatMapper;
import com.qglt.ego.rpc.pojo.TbContent;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by qingt on 2019/7/7.
 */
@Component
@Aspect
public class RedisAop {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Resource(name = "redisTemplate")
    private ValueOperations<String,Object> valueOperations;

    //准备切入点
    @Pointcut("@anotation(com.qglt.ego.rpc.service.impl.annotation.RequestPermission)")
    public void cut() {}

    @Around("cut()")
    public Object around(ProceedingJoinPoint joinPoint){


        String key = "";
        Object result = null;

        if (redisTemplate.hasKey(key)){
            //如果缓存有该key的数据,则直接从缓存中获取数据
            result = valueOperations.get(key);
        }else {
        }


        return  result;
    }




}

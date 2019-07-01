package com.qglt.ego.manager.controller;

import com.qglt.ego.rpc.pojo.TbUser;
import com.qglt.ego.rpc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by qingt on 2019/7/1.
 */
@Controller
public class UserController {
    @Resource
    private IUserService userServiceProxy;

    @RequestMapping("user/queryUserByUserId/{userId}")
    @ResponseBody
    public TbUser queryUserByUserId(@PathVariable Long userId){
        return userServiceProxy.queryUserByUserId(userId);

    }}

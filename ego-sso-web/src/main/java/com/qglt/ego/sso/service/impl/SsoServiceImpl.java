package com.qglt.ego.sso.service.impl;

import com.qglt.ego.common.model.EgoResult;
import com.qglt.ego.common.utils.CookieUtils;
import com.qglt.ego.common.utils.JsonUtils;
import com.qglt.ego.rpc.pojo.TbUser;
import com.qglt.ego.rpc.service.IUserService;
import com.qglt.ego.sso.service.ISsoService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

/**
 * Created by qingt on 2019/7/8.
 */
@Service
public class SsoServiceImpl implements ISsoService {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Resource
    private IUserService userServiceProxy;

    @Override
    public EgoResult userCheck(String param, Integer type) {
        return userServiceProxy.userCheck(param,type);
    }

    @Override
    public EgoResult saveUser(TbUser user) {
        user.setCreated(new Date());
        user.setUpdated(new Date());
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        return userServiceProxy.saveUser(user);
    }

    @Override
    public EgoResult loginCheck(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        EgoResult egoResult = new EgoResult();
        TbUser user = userServiceProxy.queryUserByUserName(username);
        if (user == null){
            egoResult.setStatus(500);
            egoResult.setMsg("该用户不存在!");
            return egoResult;
        }

        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!user.getPassword().equals(password)){
            egoResult.setStatus(500);
            egoResult.setMsg("密码不正确!");
            return egoResult;
        }

        //既然密码和用户名都对把该用户信息存到redis中
        //直接存userId不安全,通过uuid的方式生成唯一在redis中的key,相当于生成一个令牌
        String token = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(token, JsonUtils.objectToJson(user));

        //将key响应给客户端 也就是令牌token
        CookieUtils.setCookie(request,response,"sso_token",token);
        egoResult.setMsg("用户登录成功!");
        return egoResult;
    }

    @Override
    public EgoResult userInfo(String token) {
        TbUser user = JsonUtils.jsonToPojo((String) redisTemplate.opsForValue().get(token),TbUser.class);
        EgoResult result = new EgoResult();
        result.setData(user);
        return result;
    }

    @Override
    public EgoResult userLogout(String token, HttpServletRequest request, HttpServletResponse response) {
        redisTemplate.delete(token);
        CookieUtils.deleteCookie(request,response,token);
        return new EgoResult();
    }
}

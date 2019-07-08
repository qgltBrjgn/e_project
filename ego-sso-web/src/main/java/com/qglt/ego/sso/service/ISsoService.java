package com.qglt.ego.sso.service;

import com.qglt.ego.common.model.EgoResult;
import com.qglt.ego.rpc.pojo.TbUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by qingt on 2019/7/8.
 */
public interface ISsoService {
    public EgoResult userCheck(String param, Integer type);

    EgoResult saveUser(TbUser user);

    EgoResult loginCheck(String username, String password, HttpServletRequest request, HttpServletResponse response);

    EgoResult userInfo(String token);

    EgoResult userLogout(String token, HttpServletRequest request, HttpServletResponse response);
}

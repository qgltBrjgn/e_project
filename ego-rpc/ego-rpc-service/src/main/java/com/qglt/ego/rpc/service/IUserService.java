package com.qglt.ego.rpc.service;

import com.qglt.ego.common.model.EgoResult;
import com.qglt.ego.rpc.pojo.TbUser;

/**
 * Created by qingt on 2019/7/1.
 */
public interface IUserService {
    public TbUser queryUserByUserId(Long userId);

    EgoResult userCheck(String param, Integer type);

    EgoResult saveUser(TbUser user);

    TbUser queryUserByUserName(String username);
}

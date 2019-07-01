package com.qglt.ego.rpc.service;

import com.qglt.ego.rpc.pojo.TbUser;

/**
 * Created by qingt on 2019/7/1.
 */
public interface IUserService {
    public TbUser queryUserByUserId(Long userId);
}

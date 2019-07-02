package com.qglt.ego.rpc.service;

import com.qglt.ego.rpc.pojo.TbItemDesc;

/**
 * Created by qingt on 2019/7/2.
 */
public interface IItemDescService {
    public TbItemDesc queryItemDescByItemId(Long itemId);
}

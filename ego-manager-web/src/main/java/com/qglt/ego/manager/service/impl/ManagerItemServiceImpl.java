package com.qglt.ego.manager.service.impl;

import com.qglt.ego.common.model.PageResult;
import com.qglt.ego.manager.service.IManagerItemService;
import com.qglt.ego.rpc.pojo.TbItem;
import com.qglt.ego.rpc.query.ItemQuery;
import com.qglt.ego.rpc.service.IItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by qingt on 2019/7/1.
 */
@Service
public class ManagerItemServiceImpl implements IManagerItemService{

    @Resource
    private IItemService iItemServiceProxy;

    @Override
    public PageResult<TbItem> itemList(ItemQuery itemQuery) {
        return iItemServiceProxy.queryItemsListByParams(itemQuery);
    }
}

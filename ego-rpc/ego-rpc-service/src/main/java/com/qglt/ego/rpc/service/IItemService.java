package com.qglt.ego.rpc.service;

import com.qglt.ego.common.model.PageResult;
import com.qglt.ego.rpc.pojo.TbItem;
import com.qglt.ego.rpc.query.ItemQuery;

/**
 * Created by qingt on 2019/7/1.
 */
public interface IItemService {
    public PageResult<TbItem> queryItemsListByParams(ItemQuery itemQuery);
}

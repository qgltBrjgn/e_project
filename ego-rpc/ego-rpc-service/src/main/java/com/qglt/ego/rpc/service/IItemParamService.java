package com.qglt.ego.rpc.service;

import com.qglt.ego.common.model.EgoResult;
import com.qglt.ego.common.model.PageResult;
import com.qglt.ego.rpc.pojo.TbItemParam;
import com.qglt.ego.rpc.query.ItemParamQuery;

/**
 * Created by qingt on 2019/7/4.
 */
public interface IItemParamService {
    public PageResult<TbItemParam> queryItemListByParams(ItemParamQuery itemParamQuery);

    TbItemParam queryItemParamByItemCatId(Long itemCatId);

    EgoResult saveItem(TbItemParam itemParam);

    EgoResult deleteItemParamBatch(Long[] ids);
}

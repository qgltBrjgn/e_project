package com.qglt.ego.manager.service;

import com.qglt.ego.common.model.EgoResult;
import com.qglt.ego.common.model.PageResult;
import com.qglt.ego.rpc.pojo.TbItemParam;
import com.qglt.ego.rpc.query.ItemParamQuery;

/**
 * Created by qingt on 2019/7/4.
 */
public interface IManagerItemParamService {
    PageResult<TbItemParam> queryItemParamListByParams(ItemParamQuery itemParamQuery);

    EgoResult queryItemParamByItemCatId(Long itemCatId);

    EgoResult saveItem(Long itemCatId, String paramData);

    EgoResult deleteItemParamBatch(Long[] ids);
}

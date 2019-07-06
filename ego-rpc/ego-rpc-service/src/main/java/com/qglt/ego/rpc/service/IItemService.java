package com.qglt.ego.rpc.service;

import com.qglt.ego.common.model.EgoResult;
import com.qglt.ego.common.model.PageResult;
import com.qglt.ego.rpc.pojo.TbItem;
import com.qglt.ego.rpc.pojo.TbItemDesc;
import com.qglt.ego.rpc.pojo.TbItemParamItem;
import com.qglt.ego.rpc.query.ItemQuery;

/**
 * Created by qingt on 2019/7/1.
 */
public interface IItemService {
    public PageResult<TbItem> queryItemsListByParams(ItemQuery itemQuery);

    //商品状态更新
    public EgoResult updateItemStatusBatch(Long[] ids,int type);

    //商品删除
    public EgoResult deleteItemBatch(Long[] ids);


    public EgoResult saveItem(TbItem tbItem, TbItemDesc itemDesc, TbItemParamItem itemParamItem);
}

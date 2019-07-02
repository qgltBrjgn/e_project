package com.qglt.ego.manager.service;

import com.qglt.ego.common.model.EgoResult;
import com.qglt.ego.common.model.PageResult;
import com.qglt.ego.rpc.pojo.TbItem;
import com.qglt.ego.rpc.query.ItemQuery;

/**
 * Created by qingt on 2019/7/1.
 */
public interface IManagerItemService {
    public PageResult<TbItem> itemList(ItemQuery itemQuery);

    //上架
    public EgoResult reshelf(Long[] ids);

    //下架
    public EgoResult instock(Long[] ids);

    public EgoResult deleteItemBatch(Long[] ids);

    EgoResult saveItem(TbItem tbItem, String desc);
}

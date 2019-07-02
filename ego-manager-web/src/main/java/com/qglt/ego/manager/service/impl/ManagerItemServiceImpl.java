package com.qglt.ego.manager.service.impl;

import com.qglt.ego.common.model.EgoResult;
import com.qglt.ego.common.model.PageResult;
import com.qglt.ego.common.utils.IDUtils;
import com.qglt.ego.manager.service.IManagerItemService;
import com.qglt.ego.rpc.pojo.TbItem;
import com.qglt.ego.rpc.pojo.TbItemDesc;
import com.qglt.ego.rpc.query.ItemQuery;
import com.qglt.ego.rpc.service.IItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

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

    @Override
    public EgoResult reshelf(Long[] ids) {
        return iItemServiceProxy.updateItemStatusBatch(ids,1);
    }

    @Override
    public EgoResult instock(Long[] ids) {
        return iItemServiceProxy.updateItemStatusBatch(ids,2);
    }

    @Override
    public EgoResult deleteItemBatch(Long[] ids) {
        return iItemServiceProxy.deleteItemBatch(ids);
    }

    @Override
    public EgoResult saveItem(TbItem tbItem, String desc) {
        //设置商品id uuid
        Long itemId = IDUtils.genItemId();
        Date date = new Date();
        tbItem.setId(itemId);
        tbItem.setCreated(date);
        tbItem.setUpdated(date);
        tbItem.setStatus((byte) 1);

        //设置商品规格
        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(date);
        itemDesc.setUpdated(date);
        return iItemServiceProxy.saveItem(tbItem,itemDesc);
    }
}

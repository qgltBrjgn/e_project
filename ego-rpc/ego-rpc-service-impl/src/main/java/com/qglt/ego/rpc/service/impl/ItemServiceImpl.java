package com.qglt.ego.rpc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qglt.ego.common.model.EgoResult;
import com.qglt.ego.common.model.PageResult;
import com.qglt.ego.rpc.mapper.db.dao.TbItemDescMapper;
import com.qglt.ego.rpc.mapper.db.dao.TbItemMapper;
import com.qglt.ego.rpc.mapper.db.dao.TbItemParamItemMapper;
import com.qglt.ego.rpc.pojo.TbItem;
import com.qglt.ego.rpc.pojo.TbItemDesc;
import com.qglt.ego.rpc.query.ItemQuery;
import com.qglt.ego.rpc.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qingt on 2019/7/1.
 */
@Service
public class ItemServiceImpl implements IItemService{

    @Autowired
    private TbItemMapper itemMapper;

    @Autowired
    private TbItemDescMapper itemDescMapper;

    @Autowired
    private TbItemParamItemMapper itemParamItemMapper;

    @Override
    public PageResult<TbItem> queryItemsListByParams(ItemQuery itemQuery) {
        //启动分页
        PageHelper.startPage(itemQuery.getPage(),itemQuery.getRows());
        List<TbItem> itemList = itemMapper.queryItemsByParams(itemQuery);
        PageInfo<TbItem> pageInfo = new PageInfo<>(itemList);
        PageResult<TbItem> pageResult = new PageResult<>();
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setRows(pageInfo.getList());
        return pageResult;
    }

    @Override
    public EgoResult updateItemStatusBatch(Long[] ids, int type) {
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("ids",ids);
        params.put("type",type);
        itemMapper.updateItemStatusBatch(params);
        return null;
    }

    @Override
    public EgoResult deleteItemBatch(Long[] ids) {
        /**
         * 涉及表
         *  tb_item
         *  tb_item_desc
         *  tb_item_param_item
         */
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("ids",ids);
        //在tb_item表改变状态
        itemMapper.deleteItemBatch(param);
        //删除商品描述记录
        itemDescMapper.deleteItemDescBatch(param);
        //删除商品规格记录
        itemParamItemMapper.deleteItemParamItemBatch(param);
        return new EgoResult();
    }

    @Override
    public EgoResult saveItem(TbItem tbItem, TbItemDesc itemDesc) {
        itemMapper.insertSelective(tbItem);
        itemDescMapper.insertSelective(itemDesc);
        return new EgoResult();
    }
}

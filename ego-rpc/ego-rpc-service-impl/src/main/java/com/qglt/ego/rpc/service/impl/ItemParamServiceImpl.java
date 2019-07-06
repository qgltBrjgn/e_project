package com.qglt.ego.rpc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qglt.ego.common.model.EgoResult;
import com.qglt.ego.common.model.PageResult;
import com.qglt.ego.rpc.mapper.db.dao.TbItemParamMapper;
import com.qglt.ego.rpc.pojo.TbItemParam;
import com.qglt.ego.rpc.query.ItemParamQuery;
import com.qglt.ego.rpc.service.IItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qingt on 2019/7/4.
 */
@Service
public class ItemParamServiceImpl implements IItemParamService {
    @Autowired
    private TbItemParamMapper itemParamMapper;
    @Override
    public PageResult<TbItemParam> queryItemListByParams(ItemParamQuery itemParamQuery) {
        PageHelper.startPage(itemParamQuery.getPage(),itemParamQuery.getRows());
        List<TbItemParam> itemParamList = itemParamMapper.queryItemListByParams(itemParamQuery);
        PageInfo<TbItemParam> pageInfo = new PageInfo<>(itemParamList);
        PageResult<TbItemParam> pageResult = new PageResult<>();
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setRows(pageInfo.getList());

        return pageResult;
    }

    @Override
    public TbItemParam queryItemParamByItemCatId(Long itemCatId) {
        return itemParamMapper.queryItemParamByItemCatId(itemCatId);
    }

    @Override
    public EgoResult saveItem(TbItemParam itemParam) {
        itemParamMapper.insertSelective(itemParam);
        return new EgoResult();
    }

    @Override
    public EgoResult deleteItemParamBatch(Long[] ids) {
        itemParamMapper.deleteItemParamBatch(ids);
        return new EgoResult();
    }
}

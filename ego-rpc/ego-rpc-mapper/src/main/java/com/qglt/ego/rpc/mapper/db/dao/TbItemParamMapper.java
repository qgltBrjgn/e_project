package com.qglt.ego.rpc.mapper.db.dao;

import com.qglt.ego.rpc.pojo.TbItemParam;
import com.qglt.ego.rpc.query.ItemParamQuery;

import java.util.List;

public interface TbItemParamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItemParam record);

    int insertSelective(TbItemParam record);

    TbItemParam selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItemParam record);

    int updateByPrimaryKeyWithBLOBs(TbItemParam record);

    int updateByPrimaryKey(TbItemParam record);

    List<TbItemParam> queryItemListByParams(ItemParamQuery itemParamQuery);

    TbItemParam queryItemParamByItemCatId(Long itemCatId);

    int deleteItemParamBatch(Long[] ids);
}
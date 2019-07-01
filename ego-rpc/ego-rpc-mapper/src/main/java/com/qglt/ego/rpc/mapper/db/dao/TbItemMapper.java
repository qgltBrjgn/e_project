package com.qglt.ego.rpc.mapper.db.dao;

import com.qglt.ego.rpc.pojo.TbItem;
import com.qglt.ego.rpc.query.ItemQuery;

import java.util.List;

public interface TbItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItem record);

    int insertSelective(TbItem record);

    TbItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItem record);

    int updateByPrimaryKey(TbItem record);

    public List<TbItem> queryItemsByParams(ItemQuery itemQuery);
}
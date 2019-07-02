package com.qglt.ego.rpc.mapper.db.dao;

import com.qglt.ego.rpc.pojo.TbItemParamItem;

import java.util.Map;

public interface TbItemParamItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItemParamItem record);

    int insertSelective(TbItemParamItem record);

    TbItemParamItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItemParamItem record);

    int updateByPrimaryKeyWithBLOBs(TbItemParamItem record);

    int updateByPrimaryKey(TbItemParamItem record);

    int deleteItemParamItemBatch(Map<String, Object> param);
}
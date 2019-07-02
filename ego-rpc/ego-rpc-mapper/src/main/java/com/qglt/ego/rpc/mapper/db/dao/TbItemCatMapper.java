package com.qglt.ego.rpc.mapper.db.dao;

import com.qglt.ego.rpc.dto.TreeDto;
import com.qglt.ego.rpc.pojo.TbItemCat;

import java.util.List;

public interface TbItemCatMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItemCat record);

    int insertSelective(TbItemCat record);

    TbItemCat selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItemCat record);

    int updateByPrimaryKey(TbItemCat record);

    List<TreeDto> queryItemCatsByParentId(Long id);
}
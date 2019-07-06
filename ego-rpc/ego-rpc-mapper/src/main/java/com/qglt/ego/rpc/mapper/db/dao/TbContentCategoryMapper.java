package com.qglt.ego.rpc.mapper.db.dao;

import com.qglt.ego.rpc.dto.TreeDto;
import com.qglt.ego.rpc.pojo.TbContentCategory;

import java.util.List;

public interface TbContentCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbContentCategory record);

    int insertSelective(TbContentCategory record);

    TbContentCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbContentCategory record);

    int updateByPrimaryKey(TbContentCategory record);

    List<TreeDto> queryContentCategoryListByParentId(Long id);

    int countContentCategoryByParentId(Long parentId);
}
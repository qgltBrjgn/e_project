package com.qglt.ego.rpc.mapper.db.dao;

import com.qglt.ego.rpc.pojo.TbContent;
import com.qglt.ego.rpc.query.ContentQuery;

import java.util.List;

public interface TbContentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbContent record);

    int insertSelective(TbContent record);

    TbContent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbContent record);

    int updateByPrimaryKeyWithBLOBs(TbContent record);

    int updateByPrimaryKey(TbContent record);

    List<TbContent> queryContentListByParams(ContentQuery contentQuery);

    List<TbContent> queryContentByCategoryId(Long categoryId);

    int deleteBatch(Long[] ids);
}
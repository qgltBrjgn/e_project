package com.qglt.ego.rpc.service.impl;

import com.qglt.ego.common.model.EgoResult;
import com.qglt.ego.rpc.dto.TreeDto;
import com.qglt.ego.rpc.mapper.db.dao.TbContentCategoryMapper;
import com.qglt.ego.rpc.pojo.TbContentCategory;
import com.qglt.ego.rpc.service.IContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by qingt on 2019/7/4.
 */
@Service
public class ContentCategoryServiceImpl implements IContentCategoryService{
    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;
    @Override
    public List<TreeDto> queryContentCategoryListByParentId(Long id) {
        return contentCategoryMapper.queryContentCategoryListByParentId(id);
    }

    @Override
    public EgoResult saveContentCategory(TbContentCategory contentCategory) {
        //查询parentId对应节点 如该节点下不存在节点设置is_parent = 1
        //查询parent_id 下是否存在节点
        int count = contentCategoryMapper.countContentCategoryByParentId(contentCategory.getParentId());
        if (count == 0){
            //0表示没有节点则更新is_parent=0
            TbContentCategory parentContentCategory = new TbContentCategory();
            parentContentCategory.setId(contentCategory.getParentId());
            parentContentCategory.setIsParent(true);
            parentContentCategory.setUpdated(new Date());
            contentCategoryMapper.updateByPrimaryKeySelective(parentContentCategory);
        }
        contentCategoryMapper.insertSelective(contentCategory);
        return new EgoResult();
    }

    @Override
    public EgoResult updateContentCategory(TbContentCategory contentCategory) {
        contentCategoryMapper.updateByPrimaryKeySelective(contentCategory);
        return new EgoResult();
    }

    @Override
    public EgoResult deleteContentCategory(Long id) {
        //如果是该删除节点是父节点则不能直接删除
        //如果删除该节点父节点没有了子节点则父节点的is_parent=1
        EgoResult egoResult = null;
        TbContentCategory contentCategory = contentCategoryMapper.selectByPrimaryKey(id);
        if (contentCategory.getIsParent()){
            egoResult.setStatus(500);
            egoResult.setMsg("该节点是父节点不能直接删除!!!");
            return egoResult;
        }
        contentCategory.setUpdated(new Date());
        contentCategory.setStatus(2);
        contentCategoryMapper.updateByPrimaryKeySelective(contentCategory);//执行删除操作
        int parentCount = contentCategoryMapper.countContentCategoryByParentId(contentCategory.getParentId());
        if (parentCount == 0){
            //0表示该删除的父节点没有另外子节点了,设置为子节点 is_parent = 0
            TbContentCategory parentContentCategory = new TbContentCategory();
            parentContentCategory.setIsParent(false);
            parentContentCategory.setUpdated(new Date());
            contentCategoryMapper.updateByPrimaryKeySelective(parentContentCategory);
        }
        return new EgoResult();
    }
}

package com.qglt.ego.manager.service.impl;

import com.qglt.ego.common.model.EgoResult;
import com.qglt.ego.manager.service.IManagerContentCategoryService;
import com.qglt.ego.rpc.dto.TreeDto;
import com.qglt.ego.rpc.pojo.TbContentCategory;
import com.qglt.ego.rpc.service.IContentCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by qingt on 2019/7/4.
 */
@Service
public class ManagerContentCategoryServiceImpl implements IManagerContentCategoryService{

    @Resource
    private IContentCategoryService iContentCategoryServiceProxy;

    @Override
    public List<TreeDto> queryContentCategoryListByParentId(Long id) {
        return iContentCategoryServiceProxy.queryContentCategoryListByParentId(id);
    }

    @Override
    public EgoResult saveContentCategory(TbContentCategory contentCategory) {
        Date date = new Date();
        contentCategory.setCreated(date);
        contentCategory.setUpdated(date);
        contentCategory.setSortOrder(1);
        contentCategory.setIsParent(false);//叶子节点
        return iContentCategoryServiceProxy.saveContentCategory(contentCategory);
    }

    @Override
    public EgoResult updateContentCategory(TbContentCategory contentCategory) {
        return iContentCategoryServiceProxy.updateContentCategory(contentCategory);
    }

    @Override
    public EgoResult deleteContentCategory(Long id) {
        return iContentCategoryServiceProxy.deleteContentCategory(id);
    }
}

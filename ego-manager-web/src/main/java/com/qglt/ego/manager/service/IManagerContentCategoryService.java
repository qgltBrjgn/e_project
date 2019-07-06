package com.qglt.ego.manager.service;

import com.qglt.ego.common.model.EgoResult;
import com.qglt.ego.rpc.dto.TreeDto;
import com.qglt.ego.rpc.pojo.TbContentCategory;

import java.util.List;

/**
 * Created by qingt on 2019/7/4.
 */
public interface IManagerContentCategoryService {
    List<TreeDto> queryContentCategoryListByParentId(Long id);

    EgoResult saveContentCategory(TbContentCategory contentCategory);

    EgoResult updateContentCategory(TbContentCategory contentCategory);

    EgoResult deleteContentCategory(Long id);
}

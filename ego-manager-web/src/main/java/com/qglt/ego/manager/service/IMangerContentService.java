package com.qglt.ego.manager.service;

import com.qglt.ego.common.model.EgoResult;
import com.qglt.ego.common.model.PageResult;
import com.qglt.ego.rpc.pojo.TbContent;
import com.qglt.ego.rpc.query.ContentQuery;

/**
 * Created by qingt on 2019/7/4.
 */
public interface IMangerContentService {
    PageResult<TbContent> queryContentListByParams(ContentQuery contentQuery);

    EgoResult deleteContent(Long[] ids);

    EgoResult saveContent(TbContent content);
}

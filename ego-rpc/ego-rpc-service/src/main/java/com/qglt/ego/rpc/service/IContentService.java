package com.qglt.ego.rpc.service;

import com.qglt.ego.common.model.BigPicture;
import com.qglt.ego.common.model.EgoResult;
import com.qglt.ego.common.model.PageResult;
import com.qglt.ego.rpc.pojo.TbContent;
import com.qglt.ego.rpc.query.ContentQuery;

import java.util.List;

/**
 * Created by qingt on 2019/7/4.
 */
public interface IContentService {
    PageResult<TbContent> queryContentListByParams(ContentQuery contentQuery);

    List<BigPicture> queryContentByCategoryId(Long categoryId);

    EgoResult delete(Long[] ids);

    EgoResult saveContent(TbContent content);
}

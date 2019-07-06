package com.qglt.ego.manager.service.impl;

import com.qglt.ego.common.model.EgoResult;
import com.qglt.ego.common.model.PageResult;
import com.qglt.ego.manager.service.IMangerContentService;
import com.qglt.ego.rpc.pojo.TbContent;
import com.qglt.ego.rpc.query.ContentQuery;
import com.qglt.ego.rpc.service.IContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by qingt on 2019/7/4.
 */
@Service
public class ManagerContentServiceImpl implements IMangerContentService {

    @Resource
    private IContentService contentServiceProxy;

    @Override
    public PageResult<TbContent> queryContentListByParams(ContentQuery contentQuery) {
        return contentServiceProxy.queryContentListByParams(contentQuery);
    }

    @Override
    public EgoResult deleteContent(Long[] ids) {
        return contentServiceProxy.delete(ids);
    }

    @Override
    public EgoResult saveContent(TbContent content) {
        return contentServiceProxy.saveContent(content);
    }
}

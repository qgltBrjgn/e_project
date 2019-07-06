package com.qglt.ego.portal.service.impl;

import com.qglt.ego.common.model.BigPicture;
import com.qglt.ego.portal.service.IPortalContentService;
import com.qglt.ego.rpc.service.IContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by qingt on 2019/7/5.
 */
@Service
public class PortalContentServiceImpl implements IPortalContentService {

    @Resource
    private IContentService contentServiceProxy;

    @Override
    public List<BigPicture> queryContentByCategoryId(Long categoryId) {
        return contentServiceProxy.queryContentByCategoryId(categoryId);
    }
}

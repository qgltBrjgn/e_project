package com.qglt.ego.portal.service;

import com.qglt.ego.common.model.BigPicture;

import java.util.List;

/**
 * Created by qingt on 2019/7/5.
 */
public interface IPortalContentService {
    public List<BigPicture> queryContentByCategoryId(Long categoryId);
}

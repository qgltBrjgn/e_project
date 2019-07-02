package com.qglt.ego.rpc.service;

import com.qglt.ego.rpc.dto.TreeDto;

import java.util.List;

/**
 * Created by qingt on 2019/7/2.
 */
public interface IItemCatService {
    public List<TreeDto> queryItemCatsByParentId(Long id);
}

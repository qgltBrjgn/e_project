package com.qglt.ego.rpc.service.impl;

import com.qglt.ego.rpc.dto.TreeDto;
import com.qglt.ego.rpc.mapper.db.dao.TbItemCatMapper;
import com.qglt.ego.rpc.service.IItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qingt on 2019/7/2.
 */
@Service
public class ItemCatServiceImpl implements IItemCatService{
    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public List<TreeDto> queryItemCatsByParentId(Long id) {
        return itemCatMapper.queryItemCatsByParentId(id);
    }
}

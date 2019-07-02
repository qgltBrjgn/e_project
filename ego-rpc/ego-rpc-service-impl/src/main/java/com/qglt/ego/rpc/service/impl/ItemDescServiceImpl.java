package com.qglt.ego.rpc.service.impl;

import com.qglt.ego.rpc.mapper.db.dao.TbItemDescMapper;
import com.qglt.ego.rpc.pojo.TbItemDesc;
import com.qglt.ego.rpc.service.IItemDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by qingt on 2019/7/2.
 */
@Service
public class ItemDescServiceImpl implements IItemDescService {
    @Autowired
    private TbItemDescMapper itemDescMapper;
    @Override
    public TbItemDesc queryItemDescByItemId(Long itemId) {
        return itemDescMapper.selectByPrimaryKey(itemId);
    }
}

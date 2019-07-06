package com.qglt.ego.rpc.service.impl;

import com.qglt.ego.rpc.dto.TreeDto;
import com.qglt.ego.rpc.mapper.db.dao.TbItemCatMapper;
import com.qglt.ego.rpc.pojo.TbItemCat;
import com.qglt.ego.rpc.service.IItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by qingt on 2019/7/2.
 */
@Service
public class ItemCatServiceImpl implements IItemCatService{

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Resource(name = "redisTemplate")
    private ValueOperations<String,Object> valueOperations;

    @Override
    public List<TreeDto> queryItemCatsByParentId(Long id) {
        return itemCatMapper.queryItemCatsByParentId(id);
    }

    @Override
    public List<TbItemCat> queryAllItemCats() {
        /**
         * 1.从redis缓存获取缓存数据,有缓存则获取缓存返回数据
         * 2.没有缓存数据,则从数据库查询,数据库存在,查询数据放入缓存
         */
        //准备缓存的key
        String key = "itemCat::allItemCats";
        List<TbItemCat> itemCats = null;
        if (redisTemplate.hasKey(key)){
            //如果缓存有该数据则直接返回缓存数据
            System.out.println("缓存有该数据-->");
            itemCats = (List<TbItemCat>) valueOperations.get(key);
        }else {
            itemCats = itemCatMapper.queryAllItemCats();
            if (null != itemCats && itemCats.size()>0){
                //把从数据库查到的数据放入缓存
                valueOperations.set(key,itemCats);
            }
        }
        return itemCats;
    }
}

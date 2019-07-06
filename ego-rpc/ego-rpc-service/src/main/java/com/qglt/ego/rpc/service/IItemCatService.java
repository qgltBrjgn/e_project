package com.qglt.ego.rpc.service;

import com.qglt.ego.rpc.dto.TreeDto;
import com.qglt.ego.rpc.pojo.TbItemCat;

import java.util.List;

/**
 * Created by qingt on 2019/7/2.
 */
public interface IItemCatService {
    public List<TreeDto> queryItemCatsByParentId(Long id);

    public List<TbItemCat> queryAllItemCats();
}

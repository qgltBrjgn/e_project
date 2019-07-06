package com.qglt.ego.manager.service.impl;

import com.qglt.ego.common.model.EgoResult;
import com.qglt.ego.common.model.PageResult;
import com.qglt.ego.manager.service.IManagerItemParamService;
import com.qglt.ego.rpc.pojo.TbItemParam;
import com.qglt.ego.rpc.query.ItemParamQuery;
import com.qglt.ego.rpc.service.IItemParamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by qingt on 2019/7/4.
 */
@Service
public class ManagerItemParamServiceImpl implements IManagerItemParamService {
    @Resource
    private IItemParamService iItemParamServiceProxy;
    @Override
    public PageResult<TbItemParam> queryItemParamListByParams(ItemParamQuery itemParamQuery) {
        return iItemParamServiceProxy.queryItemListByParams(itemParamQuery);
    }

    @Override
    public EgoResult queryItemParamByItemCatId(Long itemCatId) {
        TbItemParam itemParam = iItemParamServiceProxy.queryItemParamByItemCatId(itemCatId);
        EgoResult egoResult = new EgoResult();
        if (null != itemParam){
            egoResult.setData(itemParam);
            egoResult.setMsg("该模板已存在");
        }
        return egoResult;
    }

    @Override
    public EgoResult saveItem(Long itemCatId, String paramData) {
        TbItemParam itemParam = new TbItemParam();
        itemParam.setItemCatId(itemCatId);
        itemParam.setParamData(paramData);
        itemParam.setCreated(new Date());
        itemParam.setUpdated(new Date());
        return iItemParamServiceProxy.saveItem(itemParam);
    }

    @Override
    public EgoResult deleteItemParamBatch(Long[] ids) {
        return iItemParamServiceProxy.deleteItemParamBatch(ids);
    }
}

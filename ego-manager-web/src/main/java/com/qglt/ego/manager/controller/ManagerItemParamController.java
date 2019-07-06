package com.qglt.ego.manager.controller;

import com.qglt.ego.common.model.EgoResult;
import com.qglt.ego.common.model.PageResult;
import com.qglt.ego.manager.service.IManagerItemParamService;
import com.qglt.ego.rpc.pojo.TbItemParam;
import com.qglt.ego.rpc.query.ItemParamQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by qingt on 2019/7/4.
 */
@Controller
public class ManagerItemParamController {

    @Resource
    private IManagerItemParamService managerItemParamService;

    @RequestMapping("item/param/list")
    @ResponseBody
    public PageResult<TbItemParam> queryItemParamListByParams(ItemParamQuery itemParamQuery){
        return managerItemParamService.queryItemParamListByParams(itemParamQuery);
    }

    @RequestMapping({"item/param/query/{itemCatId}","item/param/query/itemcatid/{itemCatId}"})
    @ResponseBody
    public EgoResult queryItemParamByItemCatId(@PathVariable Long itemCatId){
        return managerItemParamService.queryItemParamByItemCatId(itemCatId);
    }

    @RequestMapping("item/param/save/{itemCatId}")
    @ResponseBody
    public EgoResult saveItemParam(@PathVariable Long itemCatId,String paramData){
        return managerItemParamService.saveItem(itemCatId,paramData);
    }

    @RequestMapping("item/param/delete")
    @ResponseBody
    public EgoResult deleteItemParam(Long[] ids){
        return managerItemParamService.deleteItemParamBatch(ids);
    }
}

package com.qglt.ego.manager.controller;

import com.qglt.ego.common.model.PageResult;
import com.qglt.ego.manager.service.IManagerItemService;
import com.qglt.ego.rpc.pojo.TbItem;
import com.qglt.ego.rpc.query.ItemQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by qingt on 2019/7/1.
 */
@Controller
public class ManagerItemController {

    @Resource
    private IManagerItemService managerItemService;

    @RequestMapping("item/list")
    @ResponseBody
    public PageResult<TbItem> itemList(ItemQuery itemQuery){
        return managerItemService.itemList(itemQuery);
    }
}

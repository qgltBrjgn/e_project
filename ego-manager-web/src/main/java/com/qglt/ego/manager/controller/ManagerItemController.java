package com.qglt.ego.manager.controller;

import com.qglt.ego.common.model.EgoResult;
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

    /**
     * 商品上架
     */
    @RequestMapping("item/reshelf")
    @ResponseBody
    public EgoResult reshelf(Long[] ids){
        return managerItemService.reshelf(ids);
    }
    /**
     * 商品下架
     */
    @RequestMapping("item/instock")
    @ResponseBody
    public EgoResult instock(Long[] ids){
        return managerItemService.instock(ids);
    }

    /**
     * 商品删除
     */
    @RequestMapping("item/delete")
    @ResponseBody
    public EgoResult delete(Long[] ids){
        return managerItemService.deleteItemBatch(ids);
    }

    /**
     * 商品新增
     */
    @RequestMapping("item/save")
    @ResponseBody
    public EgoResult saveItem(TbItem tbItem,String desc){
        return managerItemService.saveItem(tbItem,desc);
    }
}

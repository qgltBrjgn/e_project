package com.qglt.ego.manager.controller;

import com.qglt.ego.common.model.EgoResult;
import com.qglt.ego.rpc.pojo.TbItemDesc;
import com.qglt.ego.rpc.service.IItemDescService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by qingt on 2019/7/2.
 */
@Controller
public class ManagetItemDescController {
    @Resource
    private IItemDescService iItemDescServiceProxy;

    @RequestMapping("/item/desc/{itemId}")
    @ResponseBody
    public EgoResult queryItemDescByItemId(@PathVariable Long itemId){
        EgoResult egoResult = new EgoResult();
        TbItemDesc itemDesc = iItemDescServiceProxy.queryItemDescByItemId(itemId);
        if (null != itemDesc){
            egoResult.setData(itemDesc);
        }else {
            egoResult.setStatus(500);
            egoResult.setMsg("记录不存在!");
        }
        return egoResult;
    }
}

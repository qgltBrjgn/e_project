package com.qglt.ego.manager.controller;

import com.qglt.ego.rpc.dto.TreeDto;
import com.qglt.ego.rpc.service.IItemCatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by qingt on 2019/7/2.
 */
@Controller
public class ManagerItemCatController {
    @Resource
    private IItemCatService iItemCatServiceProxy;

    @RequestMapping("item/cat/list")
    @ResponseBody
    public List<TreeDto> queryItemCatsByParentId(@RequestParam(defaultValue = "0") Long id){
        return iItemCatServiceProxy.queryItemCatsByParentId(id);
    }
}

package com.qglt.ego.manager.controller;

import com.qglt.ego.common.model.EgoResult;
import com.qglt.ego.manager.service.IManagerContentCategoryService;
import com.qglt.ego.rpc.dto.TreeDto;
import com.qglt.ego.rpc.pojo.TbContentCategory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by qingt on 2019/7/4.
 */
@Controller
public class ManagerContentCategoryController {
    @Resource
    private IManagerContentCategoryService managerContentCategoryService;

    @RequestMapping("content/category/list")
    @ResponseBody
    public List<TreeDto> queryContentCategoryListByParentId(@RequestParam(defaultValue = "0") Long id){
        return managerContentCategoryService.queryContentCategoryListByParentId(id);
    }

    @RequestMapping("content/category/create")
    @ResponseBody
    public EgoResult saveContentCategory(TbContentCategory contentCategory){
        return managerContentCategoryService.saveContentCategory(contentCategory);
    }

    @RequestMapping("content/category/update")
    @ResponseBody
    public EgoResult updateContentCategory(TbContentCategory contentCategory){
        return managerContentCategoryService.updateContentCategory(contentCategory);
    }

    @RequestMapping("content/category/delete")
    @ResponseBody
    public EgoResult deleteContentCategory(Long id){
        return managerContentCategoryService.deleteContentCategory(id);
    }

}

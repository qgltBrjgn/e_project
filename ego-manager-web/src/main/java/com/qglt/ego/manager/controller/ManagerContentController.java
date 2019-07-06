package com.qglt.ego.manager.controller;

import com.qglt.ego.common.model.EgoResult;
import com.qglt.ego.common.model.PageResult;
import com.qglt.ego.manager.service.IMangerContentService;
import com.qglt.ego.rpc.pojo.TbContent;
import com.qglt.ego.rpc.query.ContentQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by qingt on 2019/7/4.
 */
@Controller
public class ManagerContentController {

    @Resource
    private IMangerContentService mangerContentService;

    @RequestMapping("content/query/list")
    @ResponseBody
    public PageResult<TbContent> queryContentListByParams(ContentQuery contentQuery){
        return mangerContentService.queryContentListByParams(contentQuery);
    }

    @RequestMapping("/content/delete")
    @ResponseBody
    public EgoResult deleteContent(Long[] ids){
        return mangerContentService.deleteContent(ids);

    }
    @RequestMapping("/content/save")
    @ResponseBody
    public EgoResult saveContent(TbContent content){
        return mangerContentService.saveContent(content);

    }
}

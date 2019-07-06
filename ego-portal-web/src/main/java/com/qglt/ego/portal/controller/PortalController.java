package com.qglt.ego.portal.controller;

import com.qglt.ego.common.utils.JsonUtils;
import com.qglt.ego.portal.service.IPortalContentService;
import com.qglt.ego.portal.service.IPortalItemCatService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by qingt on 2019/7/5.
 */
@Controller
public class PortalController {

    @Resource
    private IPortalContentService portalContentService;

    @Resource
    private IPortalItemCatService portalItemCatService;

    @RequestMapping(value = "/item/cat",produces = MediaType.TEXT_HTML_VALUE+";charset=UTF-8")
    @ResponseBody
    public String getAllCats(){
        Map<String,Object> map = portalItemCatService.getAllCats();
        return JsonUtils.objectToJson(map);
    }

    @RequestMapping(value = "content/index/list",produces = MediaType.TEXT_HTML_VALUE+";charset=UTF-8")
    @ResponseBody
    public String queryContentByCategoryId(Long categoryId){
        return JsonUtils.objectToJson(portalContentService.queryContentByCategoryId(categoryId));
    }
}

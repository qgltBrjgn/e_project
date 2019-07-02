package com.qglt.ego.manager.controller;

import com.qglt.ego.common.model.PictureResult;
import com.qglt.ego.manager.service.IManagerFileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by qingt on 2019/7/2.
 */
@Controller
public class ManagerFileController {

    @Resource
    private IManagerFileService managerFileService;

    @RequestMapping("pic/upload")
    @ResponseBody
    public PictureResult uploadFile(HttpServletRequest request){
        MultipartHttpServletRequest mhsf = (MultipartHttpServletRequest) request;
        MultipartFile mf = mhsf.getFile("uploadFile");
        return managerFileService.uploadFile(mf);
    }

}

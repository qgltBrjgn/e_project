package com.qglt.ego.manager.service;

import com.qglt.ego.common.model.PictureResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by qingt on 2019/7/2.
 */
public interface IManagerFileService {
    public PictureResult uploadFile(MultipartFile mf);
}

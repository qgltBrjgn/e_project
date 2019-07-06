package com.qglt.ego.manager.service.impl;

import com.google.gson.Gson;
import com.qglt.ego.common.model.PictureResult;
import com.qglt.ego.manager.service.IManagerFileService;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by qingt on 2019/7/2.
 */
@Service
public class ManagerFileServiceImpl implements IManagerFileService {
    private String ak = "yByVgMxD4LyQ-lMt7YuoUbZ4VJlUiwkExkqKwqJu";
    private String sk = "bTteR-1uVF5ERik9SKCpczD_m0DKMAHzVuZh5o09";
    private String bucket = "ego-static-resources";
    private String basePath="http://pu67wqmp1.bkt.clouddn.com/";
    @Override
    public PictureResult uploadFile(MultipartFile mf) {
        PictureResult result = new PictureResult();
        try {
            if (null != mf && mf.getSize() > 0) {
                Configuration cfg = new Configuration(Zone.zone0());
                UploadManager uploadManager = new UploadManager(cfg);
                String fileName = mf.getOriginalFilename();
                String ext = fileName.substring(fileName.lastIndexOf("."));// 文件后缀
                String key = System.currentTimeMillis() + ext;
                Auth auth = Auth.create(ak, sk);
                String upToken = auth.uploadToken(bucket);
                Response response = uploadManager.put(mf.getInputStream(), key, upToken, null, null);
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                result.setError(0);
                result.setMessage("ok");
                result.setUrl(basePath+key);
            }else{
                result.setError(1);
                result.setMessage("error");
                result.setUrl("");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setError(1);
            result.setMessage("error");
            result.setUrl("");
        }
        return result;
    }
}

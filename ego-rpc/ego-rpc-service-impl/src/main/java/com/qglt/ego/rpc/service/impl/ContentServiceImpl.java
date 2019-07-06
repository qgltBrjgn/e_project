package com.qglt.ego.rpc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qglt.ego.common.model.BigPicture;
import com.qglt.ego.common.model.EgoResult;
import com.qglt.ego.common.model.PageResult;
import com.qglt.ego.rpc.mapper.db.dao.TbContentMapper;
import com.qglt.ego.rpc.pojo.TbContent;
import com.qglt.ego.rpc.query.ContentQuery;
import com.qglt.ego.rpc.service.IContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by qingt on 2019/7/4.
 */
@Service
public class ContentServiceImpl implements IContentService {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Resource(name = "redisTemplate")
    private ValueOperations<String,Object> valueOperations;

    @Autowired
    private TbContentMapper contentMapper;

    @Override
    public PageResult<TbContent> queryContentListByParams(ContentQuery contentQuery) {
        PageHelper.startPage(contentQuery.getPage(),contentQuery.getRows());
        List<TbContent> contentList = contentMapper.queryContentListByParams(contentQuery);
        PageInfo<TbContent> pageInfo = new PageInfo<>(contentList);
        PageResult<TbContent> pageResult = new PageResult<>();
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setRows(pageInfo.getList());
        return pageResult;
    }

    @Override
    public List<BigPicture> queryContentByCategoryId(Long categoryId) {
        List<BigPicture> pictures = null;
        List<TbContent> contentList = null;
        String key = "content::queryContentByCategoryId::categoryId::"+categoryId;
        if (redisTemplate.hasKey(key)){
            contentList = (List<TbContent>) valueOperations.get(key);
        }else {
            contentList = contentMapper.queryContentByCategoryId(categoryId);
            if (null != contentList && contentList.size()>0){
                valueOperations.set(key,contentList);
            }
        }
        if (null != contentList && contentList.size()>0){
            pictures = new ArrayList<>();
            List<BigPicture> finalPictures = pictures;
            contentList.forEach(c->{
                BigPicture bigPicture = new BigPicture();
                bigPicture.setAlt("ego商城");
                bigPicture.setHref(c.getUrl());
                System.out.println(c.getPic());
                bigPicture.setSrc(c.getPic());
                bigPicture.setSrcb(c.getPic2());
                finalPictures.add(bigPicture);
            });
        }
        return pictures;
    }

    @Override
    public EgoResult delete(Long[] ids) {
        contentMapper.deleteBatch(ids);
        //清楚缓存  模糊匹配广告内容key
        Set<String> keys = redisTemplate.keys("content::*");
        redisTemplate.delete(keys);
        return new EgoResult();
    }

    @Override
    public EgoResult saveContent(TbContent content) {
        contentMapper.insertSelective(content);
        //清楚缓存  缓存同步
        redisTemplate.delete(redisTemplate.keys("content::*"));
        return new EgoResult();
    }
}

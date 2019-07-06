package com.qglt.ego.portal.service.impl;

import com.qglt.ego.common.model.CatNode;
import com.qglt.ego.portal.service.IPortalItemCatService;
import com.qglt.ego.rpc.pojo.TbItemCat;
import com.qglt.ego.rpc.service.IItemCatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qingt on 2019/7/5.
 */
@Service
public class PortalItemCatServiceImpl implements IPortalItemCatService{

    @Resource
    private IItemCatService itemCatServiceProxy;
    @Override
    public Map<String, Object> getAllCats() {

        List<TbItemCat> allList = itemCatServiceProxy.queryAllItemCats();

        //分类数据处理
        List catList = getAllChildrenList(0L,allList);
        Map<String,Object> map = new HashMap<>();
        map.put("data",catList);
        return map;
    }

    private List getAllChildrenList(long parentId, List<TbItemCat> allList) {
        List result = new ArrayList();
        for (TbItemCat itemCat:allList){
            if (itemCat.getParentId().equals(parentId)){
                //父节点等于父节点id就进来  相当于从最外层类目开始遍历
                if (itemCat.getIsParent()){
                    //parentId是0的就是一级节点
                    CatNode catNode = new CatNode();
                    if (itemCat.getParentId().equals(0L)){
                        //一级分类
                        catNode.setName("<a href='/products/"+itemCat.getId()+".html'>"+itemCat.getName()+"</a>");
                    }else {
                        //二级分类 二级分类就不用设置html了
                        catNode.setName(itemCat.getName());
                    }
                    //一级节点和二级节点的话除了name还有url和子节点list设置
                    catNode.setUrl("/products/"+itemCat.getId()+".html");
                    //如果该节点还有子节点那么在调用该方法就行了此时的parentId就是该itemCat的id
                    catNode.setList(getAllChildrenList(itemCat.getId(),allList));
                    result.add(catNode);
                }else {
                    //如果不是isParent=true的话就是三级节点 底下什么子节点都没有
                    result.add("/products/" + itemCat.getId() + ".html|" + itemCat.getName());
                }
            }
        }
        return result;
    }
}

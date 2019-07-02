package com.qglt;

import com.qglt.ego.rpc.service.IItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by qingt on 2019/7/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-dao.xml",
"classpath:spring/applicationContext-service.xml","classpath:spring/applicationContext-tx.xml"})
public class TestItemService {
    @Resource
    private IItemService itemService;

    @Test
    public void test01(){
        Long[] param = {679532L,635906L};
        itemService.deleteItemBatch(param);
    }
}

package com.tasks;

import com.tasks.dataObj.VIPUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class QueryTests {
    @Autowired
    private KieSession kieSession;

    @Test
    public void queryDataTest(){
        List<VIPUser> vipUserList=new ArrayList<>();
        VIPUser vipUser1=new VIPUser();
        vipUser1.setName("张三");
        vipUser1.setVipNo("110");
        vipUserList.add(vipUser1);
        VIPUser vipUser2=new VIPUser();
        vipUser2.setName("张三");
        vipUser2.setVipNo("110");
        vipUserList.add(vipUser2);
        VIPUser vipUser3=new VIPUser();
        vipUser3.setName("张三");
        vipUser3.setVipNo("110");
        vipUserList.add(vipUser3);
        VIPUser vipUser4=new VIPUser();
        vipUser4.setName("张三");
        vipUser4.setVipNo("110");
        vipUserList.add(vipUser4);
        VIPUser vipUser5=new VIPUser();
        vipUser5.setName("张三");
        vipUser5.setVipNo("110");
        vipUserList.add(vipUser5);

        //设置全局变量
        kieSession.setGlobal("vipUserList",vipUserList);

    }
}

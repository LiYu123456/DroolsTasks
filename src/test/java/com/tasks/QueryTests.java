package com.tasks;

import com.tasks.agendaFilter.MyRuleNameWithAgendaFilter;
import com.tasks.dataObj.User;
import com.tasks.dataObj.VIPUser;
import org.drools.core.base.RuleNameEqualsAgendaFilter;
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
        vipUser2.setName("刘备");
        vipUser2.setVipNo("111");
        vipUserList.add(vipUser2);
        VIPUser vipUser3=new VIPUser();
        vipUser3.setName("李五");
        vipUser3.setVipNo("112");
        vipUserList.add(vipUser3);
        VIPUser vipUser4=new VIPUser();
        vipUser4.setName("刘备");
        vipUser4.setVipNo("2");
        vipUserList.add(vipUser4);
        VIPUser vipUser5=new VIPUser();
        vipUser5.setName("关羽");
        vipUser5.setVipNo("123456");
        vipUserList.add(vipUser5);

        //设置全局变量
        kieSession.setGlobal("vipUserList",vipUserList);
        User user1=new User();
        user1.setName("张三");
        user1.setAge(12);

        User user2=new User();
        user2.setName("刘备");
        user2.setAge(12);

        kieSession.insert(user1);

        kieSession.insert(user2);
        kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("queryTest"));
        kieSession.dispose();
    }
}

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class QueryTests {
    @Autowired
    private KieSession kieSession;

    @Test
    public void queryDataVIPUserTest(){
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
//        kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("queryTest"));
        kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("queryTest3"));
        kieSession.dispose();
    }


    @Test
    public void queryDataMapTest(){
        List<Map<String,Object>> vipUserList=new ArrayList<>();

        Map map1=new HashMap();
        map1.put("name","张三");
        map1.put("vipNo","110");
        vipUserList.add(map1);

        Map map2=new HashMap();
        map2.put("name","刘备");
        map2.put("vipNo","111");
        vipUserList.add(map2);

        Map map3=new HashMap();
        map3.put("name","李五");
        map3.put("vipNo","112");
        vipUserList.add(map3);

        Map map4=new HashMap();
        map4.put("name","刘备");
        map4.put("vipNo","123456");
        vipUserList.add(map4);


        Map map5=new HashMap();
        map5.put("name","关羽");
        map5.put("vipNo","123456");
        vipUserList.add(map5);


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
        kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("queryMapTest"));
        kieSession.dispose();
    }

    @Test
    public void  strTest(){

//        User user2=new User();
//        user2.setName("备张备");
//        user2.setAge(12);
        Map<String,Object> map=new HashMap<>();
        map.put("name","张三");
        map.put("desc","三");
        map.put("age","12");

        kieSession.insert(map);

        kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("strTest1"));
        kieSession.dispose();
    }
}

package com.tasks;

import com.tasks.agendaFilter.MyRuleNameWithAgendaFilter;
import com.tasks.dataObj.User;
import org.drools.core.base.RuleNameEndsWithAgendaFilter;
import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HelloWorldTests {

    @Autowired
    private KieSession kieSession;

    @Test
    public void testHelloWorld(){
        kieSession.fireAllRules();
    }

    @Test
    public void testUser(){

        List list=new ArrayList<>();
        kieSession.setGlobal("myGlobalList",list);
        /**
         * 执行所有的规则
         */
//        kieSession.fireAllRules();
        User user1=new User();
        user1.setName("张三");
        user1.setAge(18);
        user1.setGender("女");
        kieSession.insert(user1);
        User user2=new User();
        user2.setName("李四");
        user2.setAge(20);
        user2.setGender("女");
        kieSession.insert(user2);
        /**
         * 执行指定名字的SQL
         */
        kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("user"));
        User user3=new User();
        user3.setName("张三");
        user3.setAge(18);
        user3.setGender("女");
        kieSession.insert(user3);
        User user4=new User();
        user4.setName("李四");
        user4.setAge(20);
        user4.setGender("女");
        kieSession.insert(user4);
        kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("user"));
//        kieSession.fireAllRules(new MyRuleNameWithAgendaFilter("user"));
//        System.out.println("得到User变了:"+user1.getGender());
    }

    @Test
    public void testOperation(){
        User user1=new User();
        user1.setName("张三");
        user1.setAge(18);
        user1.setGender("女");
        kieSession.insert(user1);
        User user2=new User();
        user2.setName("李四");
        user2.setAge(20);
        user2.setGender("女");
        kieSession.insert(user2);

        kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("opera"));
    }

    @Test
    public void testContains(){
        User user1=new User();
        user1.setName("张三");
        user1.setAge(18);
        user1.setGender("女");
        User user2=new User();
        user2.setName("四");
        user2.setAge(18);
        user2.setGender("女");
        kieSession.insert(user1);
        kieSession.insert(user2);
        kieSession.insert("三");
        kieSession.insert("四");

        kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("contains"));
    }

    @Test
    public void testMemberOf(){
        User user1=new User();
        user1.setName("张三");
        user1.setAge(18);
        user1.setGender("女");

        kieSession.insert(user1);
        String[] names={"李四","张三","王五"};

        kieSession.insert(Arrays.asList(names));

        kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("NotmemberOf"));
    }
}

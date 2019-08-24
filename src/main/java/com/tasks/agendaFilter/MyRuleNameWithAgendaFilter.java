package com.tasks.agendaFilter;

import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.api.runtime.rule.Match;

import java.util.Map;

public class MyRuleNameWithAgendaFilter implements AgendaFilter {

    private final String name;
    private final boolean accept;


    public MyRuleNameWithAgendaFilter(String name) {
        this(name, true);
    }

    public MyRuleNameWithAgendaFilter(String name, boolean accept) {
        this.name = name;
        this.accept = accept;
    }

    public String getName() {
        return this.name;
    }

    public boolean isAccept() {
        return this.accept;
    }
    @Override
    public boolean accept(Match match) {
        System.out.println("我执行了。。。。"+match.getRule().getName());
        if(match.getRule().getName()==name){
            Map<String,Object> metaMap=match.getRule().getMetaData();
            for(String key:metaMap.keySet()){
                Object obj=metaMap.get(key);
                System.out.println("Key:"+key+"    value:"+obj);
            }
            for(Object obj:match.getObjects()){
                System.out.println(obj);
            }
            for(FactHandle handle:match.getFactHandles()){
                System.out.println(handle.toExternalForm());
            }
            return true;
        }

        return false;
    }


}

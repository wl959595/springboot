package com.caesar.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @Author CaesarWang
 * @ClassName CollectionBean
 * @Description 集合Bean
 * @Date 2020/12/22 21:27
 * @Version 1.0
 **/
@Component
public class CollectionPOJO {

    //@Value("#{'${caesar.array}'.split(',')}")
    @Value("#{'1,2,3,4'.split(',')}")
    private String[] array;
    @Value("#{'${caesar.list}'.split(',')}")
    private List<Integer> list;
    @Value("#{'${caesar.set}'.split(',')}")
    private Set<Integer> set;
    @Value("#{${caesar.map}}")
    //@Value("#{{'name':'b','age':22}}")
    private Map<String,String> map;
    @Value("#{${caesar.properties}}")
    private Properties properties;

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public Set<Integer> getSet() {
        return set;
    }

    public void setSet(Set<Integer> set) {
        this.set = set;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}

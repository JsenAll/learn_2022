package com.jsen.basic;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author xiaosen
 */
public class Person {
    private String name;
    private int age;
    private String[] emails;
    private Set<String> tels;
    private List<String> address;

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public Set<String> getTels() {
        return tels;
    }

    public void setTels(Set<String> tels) {
        this.tels = tels;
    }


    public String[] getEmails() {
        return emails;
    }

    public void setEmails(String[] emails) {
        this.emails = emails;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

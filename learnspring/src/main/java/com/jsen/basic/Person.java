package com.jsen.basic;

import java.util.*;

/**
 * @author xiaosen
 */
public class Person {
    private String name;
    private int age;
    private String[] emails;
    private Set<String> tels;
    private List<String> address;
    private Map<String,String > qqs;
    private Properties p;
    private PersonDao personDao;

    public PersonDao getPersonDao() {
        return personDao;
    }

    public void printT(Person person){
        personDao.save(person);
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public Properties getP() {
        return p;
    }

    public void setP(Properties p) {
        this.p = p;
    }


    public Map<String, String> getQqs() {
        return qqs;
    }

    public void setQqs(Map<String, String> qqs) {
        this.qqs = qqs;
    }

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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", emails=" + Arrays.toString(emails) +
                ", tels=" + tels +
                ", address=" + address +
                ", qqs=" + qqs +
                ", p=" + p +
                ", personDao=" + personDao +
                '}';
    }
}

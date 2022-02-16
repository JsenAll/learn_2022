package com.jsen.basic;

/**
 * @author xiaosen
 */
public class PersonDaoImpl implements PersonDao {
    @Override
    public void save(Person person) {
        System.out.println(person.toString());
    }
}

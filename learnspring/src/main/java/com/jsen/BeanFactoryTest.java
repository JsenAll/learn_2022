package com.jsen;

import com.jsen.basic.Person;
import com.jsen.basic.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author xiaosen
 */
public class BeanFactoryTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person);
    }

    /**
     * spring context 获取bean的几种方式。
     */
    @Test
    public void getBeanMethodTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
        //方式一：传入id，以及要返回的类型
        User user = applicationContext.getBean("user", User.class);
        user.setName("sdf");
        user.setPassword("my——password");
        System.out.println("方式一：传入id，以及要返回的类型 ： " + user.toString());

        //方式二 传入id 返回Object 类型 需要自己进行强制转换。
        User user2 = (User) applicationContext.getBean("user");
        user2.setName("小明");
        user2.setPassword("your password");
        System.out.println("方式二: 传入id 返回Object 类型 需要自己进行强制转换：" + user2.toString());

        //方式三：传入class类型 返回此类型的bean 如果存放多个，则会报错。
        User user3 = applicationContext.getBean(User.class);
        user3.setName("小张");
        user3.setPassword("your password");
        System.out.println("方式三：传入class类型 返回此类型的bean 如果存放多个，则会报错。" + user3.toString());
    }

    /**
     * spring 核心api
     * getBeanDefinitionNames 获取所有的bean 的id
     */
    @Test
    public void getBeanDefinitionNamesTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String definitionName : beanDefinitionNames) {
            System.out.println(definitionName);
        }
    }

    /**
     * 判断是否包含bean
     * 两种方式判断是否包含 bean
     */
    @Test
    public void containsBeanTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
        boolean person = applicationContext.containsBean("person");
        System.out.println("containsBean()" + person);
        person = applicationContext.containsBeanDefinition("person");
        System.out.println("containsBeanDefinition" + person);
    }

    /**
     * 通过别名进行获取
     */
    @Test
    public void nameTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) applicationContext.getBean("user2");
        user.setName("小名");
        user.setPassword("ajdfaadf");
        System.out.println(user.toString());
    }

    /**
     * 对各种
     */
    @Test
    public void injectTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = applicationContext.getBean("person", Person.class);
        System.out.println("对 String 类型 进行注入 " + person.getName());
        System.out.println("对 Int 类型 进行注入 " + person.getAge());
        System.out.println("对 Array 类型 进行注入 " + Arrays.toString(person.getEmails()));
        System.out.println("对 Set 类型 进行注入 " + person.getTels().toString());
        System.out.println("对 List 类型 进行注入 " + person.getAddress().toString());
        System.out.println("对 Map 类型 进行注入 " + person.getQqs().toString());
        System.out.println("对 Properties 类型 进行注入 " + person.getP().toString());
        person.printT(person);
    }

}

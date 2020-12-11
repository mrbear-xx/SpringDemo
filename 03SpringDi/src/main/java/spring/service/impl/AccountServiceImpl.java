package spring.service.impl;

import spring.service.AccountService;

import java.util.Date;

/**
 * 构造器注入
 */
public class AccountServiceImpl implements AccountService {

    private String name;
    private Integer age;
    private Date birthday;


    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void saveAccount(){
        System.out.println("service中的saveAccount方法执行了"+name+age+birthday);
    }
}

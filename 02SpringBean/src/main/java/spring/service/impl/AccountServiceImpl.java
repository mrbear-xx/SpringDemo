package spring.service.impl;

import spring.service.AccountService;

public class AccountServiceImpl implements AccountService {


    @Override
    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了");
    }

    public void init(){
        System.out.println("对象被创建了");
    }

    public void destroy(){
        System.out.println("对象被销毁了");
    }
}



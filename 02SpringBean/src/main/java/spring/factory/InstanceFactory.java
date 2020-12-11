package spring.factory;

import spring.service.AccountService;
import spring.service.impl.AccountServiceImpl;

public class InstanceFactory {

    public AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}

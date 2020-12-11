package spring.factory;

import spring.service.AccountService;
import spring.service.impl.AccountServiceImpl;

public class StaticFactory {

    public static AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}

package spring.service.impl;

import spring.dao.AccountDao;
import spring.dao.impl.AccountDaoImpl;
import spring.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao=new AccountDaoImpl();

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}

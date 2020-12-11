package spring.dao.impl;

import spring.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {

    @Override
    public void saveAccount() {
        System.out.println("保存了账户");
    }
}

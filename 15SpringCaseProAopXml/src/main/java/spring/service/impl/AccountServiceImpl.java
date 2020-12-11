package spring.service.impl;

import spring.dao.AccountDao;
import spring.entity.Account;
import spring.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return null;
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer accountId) {

    }

    @Override
    public void transfer(String sourcename, String targetname, Float money) {
        //根据名称查询转出账户
        Account source=accountDao.findAccountByName(sourcename);
        //根据名称查询转入账户
        Account target=accountDao.findAccountByName(targetname);
        //转出账户减钱
        source.setMoney(source.getMoney()-money);
        //转入账户加钱
        target.setMoney(target.getMoney()+money);
        //更新转出账户
        accountDao.updateAccount(source);
        //更新转入账户
        accountDao.updateAccount(target);
    }

}

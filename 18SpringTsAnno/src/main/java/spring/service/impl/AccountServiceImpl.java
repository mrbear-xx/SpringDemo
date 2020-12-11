package spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.AccountDao;
import spring.entity.Account;
import spring.service.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    @Override
    public void transfer(String sourcename, String targetname, Float money) {
        //根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourcename);
        //根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetname);
        //转出账户减钱
        source.setMoney(source.getMoney() - money);
        //转入账户加钱
        target.setMoney(target.getMoney() + money);
        //更新转出账户
        accountDao.updateAccount(source);
        //更新转入账户
        accountDao.updateAccount(target);
    }

}

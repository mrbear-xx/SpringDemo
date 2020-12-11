package spring.service.impl;

import spring.dao.AccountDao;
import spring.entity.Account;
import spring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
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
//        int i=1/0;
        //更新转入账户
        accountDao.updateAccount(target);
    }

}

package spring.dao.impl;

import org.springframework.stereotype.Repository;
import spring.dao.AccountDao;

@Repository("accountDao1")
public class AccountDaoImpl implements AccountDao {

    @Override
    public void saveAccount() {
        System.out.println("调用了方法saveAccount");
    }
}

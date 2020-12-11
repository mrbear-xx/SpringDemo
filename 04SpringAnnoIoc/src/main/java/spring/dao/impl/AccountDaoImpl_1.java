package spring.dao.impl;

import org.springframework.stereotype.Repository;
import spring.dao.AccountDao;

@Repository("accountDao2")
public class AccountDaoImpl_1 implements AccountDao {

    @Override
    public void saveAccount() {
        System.out.println("调用了方法saveAccount");
    }
}

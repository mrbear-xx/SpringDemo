package spring.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import spring.dao.AccountDao;
import spring.entity.Account;

import java.util.List;

public class AccountDaoImpl2 extends JdbcDaoSupport implements AccountDao {


    @Override
    public Account findAccountById(Integer accountId) {
        List<Account> accounts = getJdbcTemplate().query("select * from account where id=?",
                new BeanPropertyRowMapper<>(Account.class), 1);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    @Override
    public Account findAccountByName(String accountName) {
        return null;
    }

    @Override
    public void updateAccount(Account account) {

    }
}

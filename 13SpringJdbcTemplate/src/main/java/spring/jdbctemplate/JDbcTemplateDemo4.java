package spring.jdbctemplate;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.dao.AccountDao;
import spring.entity.Account;

public class JDbcTemplateDemo4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        AccountDao accountDao1 = ac.getBean("accountDao1", AccountDao.class);
//        Account accountById1 = accountDao1.findAccountById(1);
//        System.out.println(accountById1);

        AccountDao accountDao2 = ac.getBean("accountDao2", AccountDao.class);
        Account accountById2 = accountDao2.findAccountById(1);
        System.out.println(accountById2);
    }
}

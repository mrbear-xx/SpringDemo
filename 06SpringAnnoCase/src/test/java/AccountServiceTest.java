import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.entity.Account;
import spring.service.AccountService;

import java.util.List;

public class AccountServiceTest {

    @Test
    public void testFindAll(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = classPathXmlApplicationContext.getBean("accountService", AccountService.class);
        List<Account> allAccount = accountService.findAllAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }

    }
}

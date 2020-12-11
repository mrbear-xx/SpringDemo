package spring.ui;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.service.AccountService;

public class Client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountServiceImpl = classPathXmlApplicationContext.getBean("accountServiceImpl", AccountService.class);
        accountServiceImpl.saveAccount();

    }

}

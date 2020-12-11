package spring.ui;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.service.AccountService;

public class Client {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean.xml");

        //1.根据默认构造函数创建bean对象
        Object accountService = classPathXmlApplicationContext.getBean("accountService");
        System.out.println(accountService);

        //2.根据set方法注入
        Object accountService1 = classPathXmlApplicationContext.getBean("accountService1");
        System.out.println(accountService1);

        //3.注入复杂数据
        AccountService accountService2 = classPathXmlApplicationContext.getBean("accountService2", AccountService.class);
        accountService2.saveAccount();
    }
}

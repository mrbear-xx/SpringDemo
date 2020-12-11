package spring.ui;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.service.AccountService;

public class Client {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean.xml");

        //1.根据默认构造函数创建bean对象
        AccountService accountService = classPathXmlApplicationContext.getBean("accountService", AccountService.class);
        System.out.println(accountService);

        //2.根据普通工厂中的方法创建对象
        AccountService accountService1 = classPathXmlApplicationContext.getBean("accountService1", AccountService.class);
        System.out.println(accountService1);

        //3.根据普通工厂中的静态方法创建对象
        AccountService accountService2 = classPathXmlApplicationContext.getBean("accountService2", AccountService.class);
        System.out.println(accountService2);


        //测试bean对象作用范围
        AccountService accountService3 = classPathXmlApplicationContext.getBean("accountService3",AccountService.class);
        AccountService accountService3_1 = classPathXmlApplicationContext.getBean("accountService3",AccountService.class);
        System.out.println(accountService3==accountService3_1);

        //测试生命周期
        AccountService accountService4 = classPathXmlApplicationContext.getBean("accountService4",AccountService.class);
        accountService4.saveAccount();
        classPathXmlApplicationContext.close();
    }

}

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.service.AccountService;

/**
 * 当使用注解的环绕通知时，会出现最终通知在后置通知之前，这是一个spring的bug
 * 使用时需要注意
 */
public class aopTest {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        AccountService as = (AccountService) ac.getBean("accountService");
        as.saveAccount();
        as.updateAccount(1);
        as.deleteAccount();
    }


}

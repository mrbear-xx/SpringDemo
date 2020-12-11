package spring.ui;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import spring.dao.AccountDao;
import spring.service.AccountService;

public class Client {

    /**
     * 获取spring的Ioc核心容器，并根据id获取对象
     *
     * ApplicationContext的三个常用实现类：
     *      ClassPathXMLApplicationContext：加载类路径下的配置文件，要求配置文件在类路径下
     *      FileSystemXMLApplicationContext：加载磁盘任意路径下的配置文件（必须有访问权限）
     *      AnnotationConfigApplicationContext：用于读取注解创建容器
     *
     * 核心容器的两个接口引发出的问题：
     *      ApplicationContext:单例对象使用
     *          它在构建核心容器时，创建对象采取的策略师采用立即加载的方式，也就是说，一读取完配置文件马上就创建配置
     *          文件中配置的对象
     *      BeanFactory:多例对象使用
     *          它在构建核心容器时，创建对象采用的策略是延迟加载的方式，也就是说，什么时候根据id创建对象了
     *          就创建对象了
     * @param args
     */
    public static void main(String[] args) {

        /**
         * 使用ApplicationContext获取核心容器
         */
        //获取核心容器对象
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //根据地获取bean对象,自己强转
        AccountService accountService = (AccountService) classPathXmlApplicationContext.getBean("accountService");
        //根据字节码强转
        AccountDao accountDao = classPathXmlApplicationContext.getBean("accountDao", AccountDao.class);
        System.out.println(accountService);
        System.out.println(accountDao);


        /**
         * 使用BeanFactory获取核心容器
         */
        ClassPathResource classPathResource = new ClassPathResource("bean.xml");
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(classPathResource);
        AccountService accountService1 = xmlBeanFactory.getBean("accountService", AccountService.class);

    }

}

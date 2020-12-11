package spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import spring.dao.AccountDao;
import spring.service.AccountService;

import javax.annotation.Resource;

/**
 * 账户的业务层实现类
 * 曾经XML的配置：
 *     <bean id="accountService" class="my.spring.service.impl.AccountServiceImpl"
 *          scope="" init-method="" destroy-method="">
 *          <property name="" value="" | ref=""></property>
 *     </bean>
 * 1.用于创建对象的：
 *      他们的作用就和在XML配置文件中编写一个<bean></bean>标签实现的功能一样
 *      @Component：把当前类对象存入spring容器中
 *      属性：
 *          value：用于指定bean的id.当我们不写时，它的默认值是当前类名，且首字母改小写。
 *      @Controller:一般用在表现层
 *      @Service:一般用在业务层
 *      @Repository:一般用在持久层
 *      以上三个注解他们的作用和Component是一模一样，他们三个是spring框架提供明确的三层使用的注解，
 *      使我们的三层对象更加清晰
 *
 * 2.用于注入数据的：
 *      他们的作用就和在XML配置文件中写<property></property>标签的作用一样的
 *      @Autowired:
 *              作用：自动按照类型注入。只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配,就可以注入成功
 *                  如果ioc容器中没有任何bean的类型和要注入的变量类型匹配，则报错
 *                  如果ioc容器中有多个bean的类型和要注入的变量类型匹配，则使用变量根据容器的key二次寻找，否则报错
 *              出现位置：可以是变量上，也可以是方法上
 *              细节：在使用注解注入时，set方法不是必须的了
 *      @Qualifier
 *              作用：再按照类中注入的基础上在按照名称注入。它在给类成员注入时不能单独使用，但是在
 *                  给方法参数注入时可以
 *              属性：
 *                  value:用于指定注入bean的id
 *      @Resource
 *              作用：直接按照bean的id注入。并且可以独立使用
 *              属性：
 *                  name：用于指定bean的id
 *      以上三个注入都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现。
 *      另外，集合类型的注入只能通过XML来实现。
 *      @Value
 *          作用：用于注入基本类型和String类型的数据
 *          属性：
 *              value：用于指定数据的值。它可以使用spring中的SpEl(也就是spring中的el表达式)
 *                  SpEl的写法：${表达式}
 *
 * 3.用于改变作用范围的：
 *      他们的作用就和在XML中使用scope属性功能是一样的
 *      @Scope
 *          作用：用于指定bean的作用范围
 *          属性：
 *              value:指定范围的取值。常用取值：singleton prototype
 *
 * 4.和生命周期有关的：（了解）
 *      他们的作用就和在bean标签中使用init和destroy方法一样的
 *      @preDestroy
 *          作用：用于指定销毁方法
 *      @PostConstruct
 *          作用：用于指定初始化方法
 */

@Service
public class AccountServiceImpl implements AccountService {

    //第一种注入方式
    @Autowired
    private AccountDao accountDao1;

    //第二种注入方式
    @Autowired
    @Qualifier("accountDao2")
    private AccountDao accountDao2;

    //第三中注入方式
    @Resource(name = "accountDao2")
    private AccountDao accountDao3;


    @Override
    public void saveAccount() {
        accountDao3.saveAccount();
    }
}

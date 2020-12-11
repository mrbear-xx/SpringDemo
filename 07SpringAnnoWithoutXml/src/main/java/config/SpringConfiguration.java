package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * 此类是一个配置类，作用和bean.xml一样
 * spring中的新注释
 * @Configuration
 *      作用：指定当前类是一个配置类
 *      细节：当配置类作为AnnotationConfigApplicationContext对象创建的参数时，注解可以不写
 *      注意：当有多个配置类时，可以都把他们当做AnnotationConfigApplicationContext的参数。
 *          此时，可以不用写@Configuration注解，配置类间为兄弟关系。或者，只使用主配置类当做参数，使用@Import引入
 *          其他配置类，此时被引入的配置类也可以不用写@Configuration注解，配置类间有父子关系。
 *          否则，其他配置类必须写@Configuration注解，且必须在主配置类中注解要扫描该配置类的包。
 * @ComponentScan
 *      作用：用于通过注解指定spring在创建容器时要扫描的包
 *      属性：value:和basePackages的作用是一样的，都是用于指定创建容器时要扫描的包。
 *          使用此注解就等同于在xml中配置了：
 *              <context:component-scan base-package="myspring"></context:component-scan>
 * @Bean
 *      作用：用于把当前方法的返回值作为bean对象存入到spring的ioc容器中
 *      属性：
 *          name：用于指定bean的id。当不写时，默认值是当前方法的名称
 *      细节：
 *          当我们使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象。
 *          查找的方式和Autowired注解的作用是一样的
 *      @Qualifier:作用也可以用于此
 *
 * @Import
 *      作用：用于导入其他配置类
 *      属性：
 *          value:用于指定其他配置类的字节码。
 *              当我们使用Import的注解之后，有Import注解的类就是父配置类，而导入的都是子配置类
 *
 * @PropertySource
 *      作用：用于指定properties文件的位置
 *      属性：
 *          value:指定文件的名称和路径。
 *              关键字：classpath，表示类路径下
 */

//@Configuration
@ComponentScan("spring")
@Import(JdbcConfig.class)
@PropertySource("jdbcConfig.properties")
public class SpringConfiguration {
}

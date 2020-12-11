package spring.jdbctemplate;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 方式二：把数据源和JdbcTemplate配置在xml文件中
 */
public class JdbcTemplateDemo2 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ca = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = ca.getBean("jdbcTemplate", JdbcTemplate.class);
        jdbcTemplate.execute("insert into account (name,money) values ('eee',1000)");
    }
}

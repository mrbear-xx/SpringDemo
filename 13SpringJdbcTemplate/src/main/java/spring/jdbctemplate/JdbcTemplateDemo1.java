package spring.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 方式一：把获取数据源和逻辑执行代码放在一个类中
 */
public class JdbcTemplateDemo1 {

    public static void main(String[] args) {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://115.159.127.240:3306/SpringDemo?serverTimeZone=HongKong");
        ds.setUsername("root");
        ds.setPassword("Lovexiaoxian.187");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        jdbcTemplate.setDataSource(ds);
        jdbcTemplate.execute("insert into account (name,money) values ('ddd',1000)");
    }
}

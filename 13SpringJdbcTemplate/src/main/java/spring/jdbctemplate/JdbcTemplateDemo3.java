package spring.jdbctemplate;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import spring.entity.Account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 方式三：把数据源和JdbcTemplate配置在xml文件中，使用JdbcTemplate的CRUD
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ca = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = ca.getBean("jdbcTemplate", JdbcTemplate.class);

        //保存
//        jdbcTemplate.update("insert into account(name,money) values (?,?)","fff",1000f);

        //更新
//        jdbcTemplate.update("update account set money=? where id=?",900f,6);

        //删除
//        jdbcTemplate.update("delete from account where id=?",6);

        //查询所有
//        List<Account> accountList = jdbcTemplate.query("select * from account where money > ?", new BeanPropertyRowMapper<>(Account.class), 500f);
//        List<Account> accountList = jdbcTemplate.query("select * from account where money > ?", new AccountRowMapper(), 500f);
//        for (Account account : accountList) {
//            System.out.println(account);
//        }

        //查询一个
//        List<Account> accounts = jdbcTemplate.query("select * from account where money = ?", new BeanPropertyRowMapper<>(Account.class), 800f);
//        System.out.println(accounts.isEmpty()?"没有内容":accounts.get(0));

        //查询返回一行一列（使用聚合函数，但不加group by子句）
        Integer integer = jdbcTemplate.queryForObject("select count(*) from account where money > ?", Integer.class, 800f);
        System.out.println(integer);
    }
}

/**
 * 定义Account的封装策略
 */
class AccountRowMapper implements RowMapper<Account>{

    /**
     * 把结果集中的数据封装到Account中，然后由spring把每个Account加到集合中
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}

package spring.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 链接的工具类，它用于从数据源中获取一个链接，并且实现和线程的绑定
 */
@Component("connectionUtils")
public class ConnectionUtils {
    private ThreadLocal<Connection> tl=new ThreadLocal<>();

    @Autowired
    private DataSource dataSource;

    /**
     * 获取当前线程上的链接
     * @return
     */
    public Connection getThreadConnection(){
        //现充ThreadLocal上获取
        Connection conn=tl.get();
        //判断当前线程上是否有链接
        try {
            if (conn==null){
                //从数据源中获取一个链接，并且存入ThreadLocal中
                conn=dataSource.getConnection();
                tl.set(conn);
            }
            //返回当前线程上的链接
            return conn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 把链接个线程解绑
     */
    public void removeConnection(){
        tl.remove();
    }
}

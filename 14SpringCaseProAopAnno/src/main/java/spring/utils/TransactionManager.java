package spring.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 和事务相关的工具类，它包含了，开启事务，提交事务，回滚事务和释放连接
 */
@Component("tsManager")
@Aspect
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* spring.service.impl.AccountServiceImpl.transfer(..))")
    private void pt(){}

    /**
     * 开启事务
     */
//    @Before("pt()")
    public void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 提交事务
     */
//    @AfterReturning("pt()")
    public void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 回滚事务
     */
//    @AfterThrowing("pt()")
    public void rollBack(){
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 释放连接
     */
//    @After("pt()")
    public void release(){
        try {
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Around("pt()")
    public Object arroundAdvice(ProceedingJoinPoint pjp){
        Object rtValue=null;
        try {
            //获取参数
            Object[] args = pjp.getArgs();
            //开启事务
            this.beginTransaction();
            //执行方法
            rtValue=pjp.proceed(args);
            //提交事务
            this.commit();
        } catch (Throwable throwable) {
            //回滚事务
            this.rollBack();
            throwable.printStackTrace();
        } finally {
            //释放资源
            this.release();
        }
        return rtValue;
    }
}

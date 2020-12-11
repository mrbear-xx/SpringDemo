package spring.factory;

import spring.service.AccountService;
import spring.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建Service的代理对象的工厂
 */
public class BeanFactory {
    private AccountService accountService;
    private TransactionManager tsManager;

    public void setTsManager(TransactionManager tsManager) {
        this.tsManager = tsManager;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public AccountService getAccountService(){
        return (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 添加事务的支持
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue=null;
                        try {
                            //开启事务
                            tsManager.beginTransaction();
                            //执行操作
                            rtValue=method.invoke(accountService,args);
                            //提交事务
                            tsManager.commit();
                            //返回结果
                            return rtValue;
                        } catch (Exception e) {
                            //回滚操作
                            tsManager.rollBack();
                            throw new RuntimeException(e);
                        } finally {
                            //释放连接
                            tsManager.release();
                        }
                    }
                });
    }
}

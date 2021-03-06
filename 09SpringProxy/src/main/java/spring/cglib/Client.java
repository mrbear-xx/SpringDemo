package spring.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Client {
    public static void main(String[] args) {
        Product product = new Product();
        product.saleProduct(1000f);

        /**
         * 动态代理:
         *      特点：字节码随用随创建，随用随加载
         *      作用：不修改源码的基础上对方法增强
         *      分类：
         *          基于接口的动态代理
         *          基于子类的动态代理
         *      基于子类的动态代理：
         *          设计的类：Enhancer
         *          提供者：第三方cglib库
         *      如何创建代理对象：
         *          使用Enhancer类中的create
         *      创建代理对象的要求：
         *          被代理类不能是最终类
         *      creat方法的参数：
         *          Class:字节码
         *              用于指定被代理对象的字节码
         *          Callback:用于增强的代码
         *              一般写的都是该接口的子接口实现类：MethodInterceptor
         */
        Product product1 = (Product) Enhancer.create(product.getClass(), new MethodInterceptor() {
            /**
             * 执行被代理对象的任何方法都会经过该方法
             * @param o
             * @param method
             * @param objects
             * @param methodProxy 当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object returnValue = null;
                Float money = (Float) objects[0];
                if ("saleProduct".equals(method.getName())) {
                    returnValue = method.invoke(product, money * 0.8f);
                }
                return returnValue;
            }
        });
        product1.saleProduct(1000f);
    }
}

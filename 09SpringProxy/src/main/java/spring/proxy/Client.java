package spring.proxy;

import spring.proxy.impl.ProductImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {

        //直接创建对象调用方法
        ProductImpl product = new ProductImpl();
        product.saleProduct(1000f);


        /**
         * 动态代理:
         *      特点：字节码随用随创建，随用随加载
         *      作用：不修改源码的基础上对方法增强
         *      分类：
         *          基于接口的动态代理
         *          基于子类的动态代理
         *      基于结构的动态代理：
         *          设计的类：Proxy
         *          提供者：JDK官方
         *      如何创建代理对象：
         *          使用Proxy类中的newProxyInstance方法
         *      创建代理对象的要求：
         *          被代理类最少实现一个接口，如果没有则不能使用
         *      newProxyInstance方法的参数：
         *          Classloader:类加载器
         *              用于加载代理对象字节码的。和被代理对象使用相同的类加载器
         *          Class[]:字节码数组
         *              它是用于让代理对象和被代理对象有相同的方法
         *          InvocationHandler:
         *              它是让我们写如何代理。我们一般都是写一个该接口的实现类，通常情况下都是匿名内部类，
         *              但不是必须的。此接口的实现类都是谁用谁写
         */
        Product proxyProduct = (Product) Proxy.newProxyInstance(product.getClass().getClassLoader(),
                product.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 作用：执行被代理对象的任何接口方法都会经过该方法
                     * @param proxy 代理对象的引用
                     * @param method 当前执行的方法
                     * @param args 当前执行方法所需的参数
                     * @return 和被代理对象方法又想用的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnValue = null;
                        Float money = (Float) args[0];
                        if ("saleProduct".equals(method.getName())) {
                            returnValue = method.invoke(product, money * 0.8f);
                        }
                        System.out.println(returnValue);
                        return returnValue;
                    }
                });

        proxyProduct.saleProduct(1000f);
    }
}

package spring.utils;

/**
 * 用于记录日志的工具类，它里面提供了公共的代码
 */
public class Logger {

    /**
     * 用于打印日志：计划让其在切入点方法执行之前执行
     */
    public void printLog(){
        System.out.println("Logger类中的printLog方法执行了");
    }
}

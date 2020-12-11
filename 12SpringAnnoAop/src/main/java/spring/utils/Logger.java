package spring.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("logger")
//表示当前类是一个切面类
@Aspect
public class Logger {

    //配置切入点
    @Pointcut("execution(public void spring.service.impl.AccountServiceImpl.saveAccount())")
    private void pt(){}

    /**
     * 用于打印日志：计划让其在切入点方法执行之前执行
     * 前置通知
     */
//    @Before("pt()")
    public void beforePrintLog() {
        System.out.println("Logger类中的beforePrintLog方法执行了");
    }

    /**
     * 后置通知通知
     */
//    @AfterReturning("pt()")
    public void afterReturningPrintLog() {
        System.out.println("Logger类中的afterReturningPrintLog方法执行了");
    }

    /**
     * 异常通知
     */
//    @AfterThrowing("pt()")
    public void afterThrowingPrintLog() {
        System.out.println("Logger类中的afterThrowingPrintLog方法执行了");
    }

    /**
     * 最终通知
     */
//    @After("pt()")
    public void afterPrintLog() {
        System.out.println("Logger类中的afterPrintLog方法执行了");
    }

    /**
     * 环绕通知
     * 问题：
     * 当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了。
     * 分析：
     * 通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法调用，而我们的代码中没有
     * 解决：
     * Spring框架为我们提供了一个接口：ProceedingJoinPoint。该接口有一个方法proceed(),此方法就
     * 相当于明确调用切入点方法。该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供
     * 该接口的实现类供我们使用。
     * spring中的环绕通知：
     * 它是spring框架为我们提供的一种可以在代码中手动控制增强方法合适执行的方式
     */
    @Around("pt()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue=null;
        try {
            Object[] args = pjp.getArgs();
            System.out.println("Logger类中的beforePrintLog方法执行了");
            rtValue = pjp.proceed(args);
            System.out.println("Logger类中的afterReturningPrintLog方法执行了");
        } catch (Throwable throwable) {
            System.out.println("Logger类中的arroundPrintingLog方法执行了");
            throwable.printStackTrace();
        }finally {
            System.out.println("Logger类中的afterPrintLog方法执行了");
        }
        return rtValue;
    }
}

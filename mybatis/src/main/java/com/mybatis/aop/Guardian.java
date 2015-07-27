package com.mybatis.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Guardian {

    @Pointcut("execution(* com.mybatis.aop.Monkey.steal*(..))")
    public void foundMonkey() {
    }

    /**
     * 前置通知
     */
    @Before("foundMonkey()")
    public void foundBefore() {
        System.out.println("【守护者】发现猴子正在进入果园...");
    }

    /**
     * 最终通知
     * 不论一个方法是如何结束的，最终通知都会运行。使用@After 注解来声明。
     * 最终通知必须准备处理正常返回和异常返回两种情况。通常用它来释放资源。 
     */
    @After("foundMonkey() && args(name,..)")
    public void foundAfter(String name) {
        System.out.println("最终通知： 【" + name + "】抓住了");
    }

    /**
     * 异常通知
     */
    @AfterThrowing("foundMonkey() && args(name,..)")
    public void doDxception(String name) {
        System.out.println("异常 ：【" + name + "】 没有偷桃，抓错了");
    }

    /**
     * 后置通知 
     * 如果捕获了异常，程序终止，将不会走到return步骤
     */
    @AfterReturning("foundMonkey() && args(name,..)")
    public void foundAfterReturnning(String name) {
        System.out.println("【守护者】抓住了猴子,守护者审问出了猴子的名字叫“" + name + "”...");
    }
    
    /**
     * 
     * 环绕通知
     * @param pjp  必须作为第一个参数
     * @return
     * @throws Throwable
     */
    @Around(value = "foundMonkey()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("环绕通知开始执行.....");
        Object value = pjp.proceed();
        System.out.println(value.toString());
        System.out.println("环绕通知结束执行.....");
        return value;
    }

}

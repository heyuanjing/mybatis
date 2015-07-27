package com.mybatis.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    private static Monkey monkey;

    static {
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:aop.xml");
        monkey = (Monkey) context.getBean("monkey");
    }

    public static void main(String[] args) {
        try {
            //猴子改变行为
            monkey.changeAction();
            monkey.stealPeaches("孙大圣的大徒弟");
        } catch (MonkeyException me) {
            System.out.println("异常原因: " + me.getMessage());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
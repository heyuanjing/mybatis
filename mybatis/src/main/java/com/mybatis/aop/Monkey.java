package com.mybatis.aop;

import org.springframework.stereotype.Component;

/** 
 * 猴子 
 * @author frank 
 * 
 */
@Component
public class Monkey {

    public static final String LOOK_PRACHES = "看桃子";
    private String             action;

    public void stealPeaches(String name) throws MonkeyException {
        if (action == LOOK_PRACHES) {
            throw new MonkeyException("猴子居然没有偷桃");
        }
        System.out.println("【猴子】" + name + "正在偷桃...");
    }

    public void changeAction() {
        action = LOOK_PRACHES;
    }
}
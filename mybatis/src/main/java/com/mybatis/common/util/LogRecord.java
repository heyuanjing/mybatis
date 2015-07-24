package com.mybatis.common.util;

import org.apache.log4j.Logger;

/**
 * 
 * @description 日志工具 
 *
 * @author heyuanjing
 * @version $Id: LogRecord.java, v 0.1 2015年7月24日 上午10:57:44 heyuanjing Exp $
 */
public class LogRecord {
    private static Logger info  = Logger.getLogger("InfoLogger");
    private static Logger error = Logger.getLogger("ErrorLogger");

    public LogRecord() {
    }

    /** 
     * 一般情况记录到/logs/infoLog.txt 
     */
    public static void info(String infomation) {
        info.info(infomation);
    }

    /** 
     * 错误信息记录到/logs/errorLog.txt 
     */
    public static void error(String infomation) {
        error.error(infomation);
    }
}

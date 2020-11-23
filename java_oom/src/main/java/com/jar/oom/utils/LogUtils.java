package com.jar.oom.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author : Jakarta
 * @version :
 * @Date : 10/17/20 10:47 PM
 * @Desc :
 */
public final class LogUtils {
    private  static Logger  mLogger = LogManager.getLogger("OOM_LOG:");

    private LogUtils() {

    }

    public  static void i(Object o){
        if (o==null) {
            return;
        }
      //  mLogger.info(o.toString());
        System.out.println(o.toString());
    }

}

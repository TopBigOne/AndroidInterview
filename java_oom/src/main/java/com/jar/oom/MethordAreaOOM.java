package com.jar.oom;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Objects;

import javax.swing.border.EmptyBorder;

/**
 * @author : Jakarta
 * @version :
 * @Date : 10/17/20 11:17 PM
 * @Desc : Metaspace-元数据区
 *         VM Args: -XX:MetaspaceSize=5m -XX:MaxMetaspaceSize=5m
 */
public class MethordAreaOOM implements Run {
    @Override
    public void execute() {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj, args);
                }
            });
        }
    }

    static class OOMObject {
    }
}

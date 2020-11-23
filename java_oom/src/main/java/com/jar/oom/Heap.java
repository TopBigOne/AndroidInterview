package com.jar.oom;

import com.jar.oom.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.RoleUnresolved;

import sun.rmi.runtime.Log;

/**
 * @author : Jakarta
 * @version :
 * @Date : 10/17/20 10:39 PM
 * @Desc : heap OOM  ： -Xmx10m
 */
public class Heap implements Run {
    @Override
    public void execute() {
        long l = Runtime.getRuntime().totalMemory();
        LogUtils.i("l" + l);
        l = l >> 20;

        LogUtils.i(" 当前堆大约：" + l + "MB");
        List<String> strings = new ArrayList<>();
        while (true) {
            strings.add("jar jar");
        }


    }
}

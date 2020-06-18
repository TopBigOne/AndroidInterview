package com.top.jar.chapter_001.t_03;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-18 00:59
 * @Desc :
 */
public class TestList {
    public static void main(String[] args) {
        List<String> rawData = new ArrayList<>();
        setData(rawData);
        for (String rawDatum : rawData) {
            System.out.println("after set:" + rawDatum);
        }
    }

    /**
     * 对集合有操作。
     *
     * @param rawData
     */
    private static void setData(List<String> rawData) {
        rawData.add("1");
        rawData.add("2");
        rawData.add("3");

    }
}

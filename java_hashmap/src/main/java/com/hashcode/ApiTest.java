package com.hashcode;

import java.util.List;
import java.util.Set;

/**
 * HashCode Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>06/08/2021</pre>
 */
public class ApiTest  {


    public static void main(String[] args) {
        ApiTest apiTest = new ApiTest();
        apiTest.before();
        apiTest.test_collisionRate();
        apiTest.test_hashArea();
    }
    private Set<String> words;


    public void before() {
        "abc".hashCode();
        // 读取文件，103976个英语单词库.txt
        words = FileUtil.readWordList("/Users/dev/Documents/Android_work/AndroidInterview-master/bug_stack_code/interview-03/103976个英语单词库.txt");
    }


    public void test_collisionRate() {
        System.out.println("单词数量：" + words.size());
        List<RateInfo> rateInfoList = HashCode.collisionRateList(words, 2, 3, 5, 7, 17, 31, 32, 33, 39, 41, 199);
        for (RateInfo rate : rateInfoList) {
            System.out.println(String.format("乘数 = %4d, 最小Hash = %11d, 最大Hash = %10d, 碰撞数量 =%6d, 碰撞概率 = %.4f%%", rate.getMultiplier(), rate.getMinHash(), rate.getMaxHash(), rate.getCollisionCount(), rate.getCollisionRate() * 100));
        }
    }


    public void test_hashArea() {
        System.out.println(HashCode.hashArea(words, 2).values());
        System.out.println(HashCode.hashArea(words, 7).values());
        System.out.println(HashCode.hashArea(words, 31).values());
        System.out.println(HashCode.hashArea(words, 32).values());
        System.out.println(HashCode.hashArea(words, 199).values());
    }

} 

package math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/22 10:12
 * @Url :
 * @Level :
 * @Desc : 求 200~300 之间的素数
 * @Counter :
 * @Answer :
 */
public class PrimeNumber {
    public static void main(String[] args) {
        PrimeNumber primeNumber = new PrimeNumber();
        System.err.println("suShu : " + primeNumber.getSu(210, 212));

    }

    public List<Integer> getSu(int start, int end) {
        List<Integer> result = new ArrayList<>();
        // step 1 : 将start 到end 范围内的数，都列出来；
        for (int curNum = start; curNum < end; curNum++) {
            // 开始校验
            // 从 2开始除
            for (int j = 2; j < curNum; j++) {
                // 能整除，curNum就不会素数，中断对currNum的操作
                if (curNum % j == 0) {
                    break;
                }
                // 达到边界，符合条件做一下累加
                if (curNum == j + 1) {
                    result.add(curNum);
                }
            }
        }
        return result;
    }

    public List<Integer> getSu2(int start, int end) {
        List<Integer> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            for (int j = 2; j < i; j++) {
                // 被一个数整除了，ps:这个数不是1 和 i 本身哦
                // 那就终止循环
                if (i % j == 0) {
                    break;
                }

                if (i == j + 1) {
                    result.add(i);
                }

            }
        }

        return result;
    }


    public List<Integer> getSu3(int start, int end) {
        if (start >= end) {
            throw new IllegalArgumentException("The end must more tha start.");
        }
        List<Integer> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) break;
                if (i == j + 1) {
                    result.add(i);
                }
            }

        }
        return result;

    }

    public List<Integer> getSu4(int start, int end) {

        List<Integer> result = new ArrayList<>();
        for (int i = start; i < end; i++) {

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    break;
                }
                if (i == j + 1) {
                    result.add(i);

                }
            }
        }
        return result;
    }
}

package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/31 19:09
 * @Desc :
 */
public class MinNumber {
    /**
     * 数组组成最小的数字
     */
    public void minNumber() {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(",");
        // case 1:
        if (str.length == 1) {
            System.out.println(str[0]);
            return;
        }
        // case 2:
        if (str.length == 2) {
            int num1 = Integer.parseInt(str[0] + str[1]);
            int num2 = Integer.parseInt(str[1] + str[0]);
            System.out.println(Math.min(num1, num2));
            return;
        }
        // case 3:
        Arrays.sort(str, Comparator.comparingInt(Integer::parseInt));
        String[] minNum = Arrays.copyOf(str, 3);
        Arrays.sort(minNum, ((o1, o2) -> (o1 + o2).compareTo(o2 + o1)));
        StringBuilder res = new StringBuilder();
        for (String s : minNum) {
            res.append(s);
        }
        System.out.println(res);

    }
}

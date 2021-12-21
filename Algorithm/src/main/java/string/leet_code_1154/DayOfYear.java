package string.leet_code_1154;

import java.util.Arrays;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/21 23:34
 * @Url : https://leetcode-cn.com/problems/day-of-the-year/
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/day-of-the-year/solution/gong-shui-san-xie-jian-dan-qian-zhui-he-lwo2g/
 */
public class DayOfYear {
    public static void main(String[] args) {

        DayOfYear dayOfYear = new DayOfYear();
        int result = dayOfYear.dayOfYear("2021-12-21");
        System.out.println("result : " + result);
    }

    static int[] nums = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int[] f = new int[13];

    static {
        for (int i = 1; i <= 12; i++) f[i] = f[i - 1] + nums[i - 1];
    }


    public int dayOfYear(String date) {
        System.out.println(Arrays.toString(f));

        String[] ss = date.split("-");
        int y = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);
        int d = Integer.parseInt(ss[2]);
        // 闰年的计算方式
        boolean isLeap = (y % 4 == 0 && y % 100 != 0) || (y % 400) == 0;

        int ans = m > 2 && isLeap ? f[m - 1] + 1 : f[m - 1];
        return ans + d;


    }
}

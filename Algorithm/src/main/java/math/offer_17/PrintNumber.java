package math.offer_17;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/5 00:57
 * @Desc : 打印从1 到最大的n为树
 * https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 */
public class PrintNumber {
    public static void main(String[] args) {
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("maxMemory : " + maxMemory);

        PrintNumber printNumber = new PrintNumber();
        int[] result = printNumber.printNumbers(2);
        System.out.println("result : " + Arrays.toString(result));

    }

    int[] res;
    int nine = 0;
    int count = 0;
    int start;
    int n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};


    public int[] printNumbers(int n) {
        this.n = n;
        int size = (int) Math.pow(10, n) - 1;
        res = new int[size];
        num = new char[n];
        start = n - 1;
        dfs(0);
        return res;
    }

    void dfs(int x) {
        if (x == n) {
            String s = String.valueOf(num).substring(start);

            if (!s.equals("0")) {
                res[count++] = Integer.parseInt(s);
            }
            if (n - start == nine) {
                start--;
            }
            return;
        }

        for (char i : loop) {
            if (i == '9') {
                nine++;
            }
            num[x] = i;
            dfs(x + 1);
        }

        nine--;
    }


}

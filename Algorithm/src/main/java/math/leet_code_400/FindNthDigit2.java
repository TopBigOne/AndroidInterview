package math.leet_code_400;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/14 02:03
 * @Desc : https://leetcode.cn/problems/nth-digit/solution/tong-ge-lai-shua-ti-la-zhao-gui-lu-by-to-nvfa/
 */
public class FindNthDigit2 {

    public int findNthDigit(int n) {
        // num表示具体的整数
        int num = 1;
        // count表示几位数
        int count = 1;
        // 9 * num * count 表示几位数总共有多少位数，比如，三位数从100~999，一共是 9 * 100 * 3 = 2700 位数
        while (n > 9 * (long) num * count) {
            // 从小到到依次减去一位数、两位数、三位数，直到减不了为止
            n -= 9 * num * count;
            // num此时记录的是几位数的第一个数，依次是1、10、100、1000
            num *= 10;
            // count表示几位数，每经过一轮加1，表示下一次判断的位数加1
            count++;
        }

        // 此时的 n 表示从 num 开始取第多少位
        // 比如，此时n=5,num=100,count=3，表示从100开始取第5位
        // 那么，100是三位，101是三位，所以，第5位肯定在101这个整数的第2位，也就是0
        // num += (n - 1) / count; 用来确定是哪个具体的整数了，这里 n-1 是为了防止边界情况，比如n=3,count=3，这时候会取超了
        // n -= (n - 1) / count * count; 用来确定是哪个具体的位，n=5-3=2，注意 4/3*3=3，不等于4
        // count-n，上面算出来的n是从高到低的第几位，通过 count-n 转成第低到高的第几位
        // (num / (int) Math.pow(10, count - n)) % 10; 取出那个位的数字


        // 确定是具体哪个整数
        num += (n - 1) / count;
        // 确定是这个整数中的哪个位
        n -= (n - 1) / count * count;

        // 取出那个位的数字
        return (num / (int) Math.pow(10, count - n)) % 10;
    }

}

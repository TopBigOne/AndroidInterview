package array.offer_11;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/22 21:12
 * @Url : https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * @Level : easy medium hard
 * @Desc : 旋转数组中的最小数字
 * @Counter : 9
 * @Answer : https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/mian-shi-ti-11-xuan-zhuan-shu-zu-de-zui-xiao-shu-3/
 */
public class MinArray {
    public int minArray(int[] numbers) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) >> 1;
            if (numbers[m] > numbers[j]) {
                i = m + 1;
                continue;
            }
            if (numbers[m] < numbers[j]) {
                j = m;
                continue;
            }
            if (numbers[m] == numbers[j]) {
                j--;
            }
        }
        return numbers[i];
    }
    public int minArray2(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else {
                int x = i;
                for(int k = i + 1; k < j; k++) {
                    if(numbers[k] < numbers[x]) x = k;
                }
                return numbers[x];
            }
        }
        return numbers[i];
    }


}

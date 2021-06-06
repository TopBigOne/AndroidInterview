package string.leet_code_13;

import java.util.HashMap;


/**
 * @author : dev
 * @version :
 * @Date :  6/6/21 8:12 PM
 * @Desc : leetcode 13 :罗马数字转整数：https://leetcode-cn.com/problems/roman-to-integer/
 * <p>
 * 题解：https://leetcode-cn.com/problems/roman-to-integer/solution/yong-shi-9993nei-cun-9873jian-dan-jie-fa-by-donesp/https://leetcode-cn.com/problems/roman-to-integer/solution/yong-shi-9993nei-cun-9873jian-dan-jie-fa-by-donesp/
 */
public class RomanToInt {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = 0;
        // 前面一个数
        int preNum = map.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            System.out.println("---------------------");
            // 当前的罗马字符
            int currNum = map.get(s.charAt(i));
            System.out.println("preNum  : "+preNum);
            System.out.println("currNum : "+currNum);
            if (preNum < currNum) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            System.out.println("sum : "+sum);

            // 更新上一个罗马字符
            preNum = currNum;

        }
        // 因为 for 循环结束了，没有 cur 了，这个 preNum，落单了...
        sum += preNum;
        return sum;


    }
}

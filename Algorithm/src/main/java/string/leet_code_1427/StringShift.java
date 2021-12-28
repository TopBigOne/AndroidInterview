package string.leet_code_1427;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/28 22:49
 * @Url :https://leetcode-cn.com/problems/perform-string-shifts/submissions/
 * @Level :  easy
 * @Desc :
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/perform-string-shifts/solution/li-yong-countlai-ji-lu-shi-ji-xu-yao-yi-mylt0/
 */
public class StringShift {
    public static void main(String[] args) {
        String a = "abc";
        String temp = a.substring(1);
        //  System.out.println("temp: " + temp);


        StringShift stringShift = new StringShift();
        //String s = "abcdefg";
        String s = "abc";
//        int[][] shift = {
//                {1, 1},
//                {1, 1},
//                {0, 2},
//        };

        int[][] shift = {
                {0, 1},
                {1, 2}

        };


        String result = stringShift.stringShift(s, shift);
        System.out.println("result :" + result);

    }

    public String stringShift(String s, int[][] shift) {
        int n = s.length();
        int count = 0;
        for (int[] ints : shift) {
            count = ints[1] % n;
            if (ints[0] == 0 && ints[1] > 0) {
                s = s.substring(count) + s.substring(0, count);
            } else {
                s = s.substring(n - count) + s.substring(0, n - count);
            }

        }
        return s;


    }
}

package tan_xin.leet_code_738;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/5 00:29
 * @Url :  https://leetcode-cn.com/problems/monotone-increasing-digits/
 * @Level :    medium
 * @Desc : 单调递增的数字
 * @Counter :  2
 * @Answer : https://leetcode-cn.com/problems/monotone-increasing-digits/solution/jian-dan-tan-xin-shou-ba-shou-jiao-xue-k-a0mp/
 * <p>
 * <p>
 * //
 * https://leetcode-cn.com/problems/monotone-increasing-digits/solution/738-dan-diao-di-zeng-de-shu-zi-tan-xin-s-vq4r/
 * video:https://www.bilibili.com/video/BV1WK4y1R71x
 */
public class MonotoneIncreasingDigits {


    public static void main(String[] args) {
        int a = 5;
        int b = a;

        int c = a - 1;
        System.out.println("result b :" + b);
        System.out.println("result c :" + c);

    }

    public int monotoneIncreasingDigits(int n) {
        String[] strings = (n + "").split("");
        int len = strings.length;
        int start = len;
        for (int i = len - 1; i > 0; i--) {
            if (Integer.parseInt(strings[i]) < Integer.parseInt(strings[i - 1])) {
                strings[i - 1] = (Integer.parseInt(strings[i - 1]) - 1) + "";
                start = i;
            }
        }
        for (int i = start; i < strings.length; i++) {
            strings[i] = "9";
        }
        return Integer.parseInt(String.join("", strings));
    }

}

package string.leet_code_434;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/3/15 10:06
 * @Url :
 * @Level :  easy
 * @Desc :  连续的不是空格的字符
 * @Counter :
 * @Answer :  https://leetcode-cn.com/problems/number-of-segments-in-a-string/solution/gong-shui-san-xie-jian-dan-zi-fu-mo-ni-t-0gx6/
 */
public class CountSegments {

    public static void main(String[] args) {
        String s = ", , , ,        a, eaefa";
        CountSegments countSegments = new CountSegments();
        int result = countSegments.countSegments(s);
        System.out.println("result :" + result);
    }


    public int countSegments(String s) {
        int length = s.length();
        int ans = 0;
        for (int leftIndex = 0; leftIndex < length; ) {
            // 屏蔽掉字符串左边的空格
            if (s.charAt(leftIndex) == ' ') {
                leftIndex++;
                continue;
            }
            // 检索从[leftIndex,length] 的单词,直到遇见一个空格结束
            while (leftIndex < length && s.charAt(leftIndex) != ' ') {
                leftIndex++;
            }
            ans++;
        }
        return ans;
    }

    public int countSegments2(String s) {
        int length = s.length();
        int result = 0;
        for (int leftIndex = 0; leftIndex < length; ) {
            if (s.charAt(leftIndex) == ' ') {
                leftIndex++;
                continue;
            }
            while (leftIndex < length && s.charAt(leftIndex) != ' ') {
                leftIndex++;
            }
            result++;
        }
        return result;
    }

    public int countSegments3(String s) {
        int length = s.length();
        int result = 0;
        for (int i = 0; i < length; ) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }

            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            result++;
        }

        return result;


    }
}

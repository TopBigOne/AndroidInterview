package string.offer_05;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/15 17:54
 * @Desc :  https://leetcode.cn/problems/ti-huan-kong-ge-lcof/
 * <p>
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        String s = "We are happy.";
        String result = replaceSpace.replaceSpace(s);
        System.out.println("result : " + result);
    }

    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     *
     * @param s "We are happy."
     * @return
     */
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

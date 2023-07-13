package string;

/**
 * @author : dev
 * @version :
 * @Date :  5/30/21 1:19 AM
 * @Desc : 测试：substring  :  包含java和C++
 */
public class Test_Substring {
    public static void main(String[] args) {
        test_substring();
        test2();

    }

    private static void test2() {
        String a = "12";
        String b = "34";

        int s = Integer.parseInt(String.valueOf(a.charAt(0)));
        System.out.println("my_s: " + s);
    }

    private static void test_substring() {
        String s = "qwertyuiop";
        String newStr = s.substring(2, 7);
        System.err.println("newStr : "+newStr);
    }
}

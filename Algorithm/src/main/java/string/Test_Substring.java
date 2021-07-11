package string;

/**
 * @author : dev
 * @version :
 * @Date :  5/30/21 1:19 AM
 * @Desc : 测试：substring
 */
public class Test_Substring {
    public static void main(String[] args) {
        test1();
        test2();

    }

    private static void test2() {
        String a = "12";
        String b = "34";

      int s =  Integer.parseInt(String.valueOf(a.charAt(0)));
        System.out.println("my_s: " + s);
    }

    private static void test1() {
        String s = "qwer";
        String newStr = s.substring(1);
        System.out.println(newStr);
    }
}

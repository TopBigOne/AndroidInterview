package char_demo;

/**
 * @author : dev
 * @version :
 * @Date :  3/13/21 11:16 AM
 * @Desc : 学习一下字符和ASCII表的关系，便于理解在刷题过程中，
 *         那些字符减法的运用；
 */
public class Char1 {
    public static void main(String[] args) {
        System.out.println('a');
        int res = 'a';
        int res2 = 'b';
        char result = 97;
        System.out.println("result : " + result);
        System.out.println("res    : " + res);
        System.out.println("res2   : " + res2);
        System.out.println("a+@: " + ('a' + '@'));

        test2();
    }

    private static void test2() {
        char nameChar = '周';
        int nameInt = '周';
        System.out.println("nameChar : " + nameChar);
        System.out.println("nameInt : " + nameInt);
    }
}

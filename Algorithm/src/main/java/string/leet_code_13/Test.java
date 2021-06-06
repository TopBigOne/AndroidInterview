package string.leet_code_13;

/**
 * @author : dev
 * @version :
 * @Date :  6/6/21 9:53 PM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        String s = "LVIII";
        RomanToInt romanToInt = new RomanToInt();
        int result = romanToInt.romanToInt(s);
        System.out.println("result : " + result);

    }
}

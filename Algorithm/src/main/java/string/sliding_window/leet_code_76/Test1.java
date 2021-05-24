package string.sliding_window.leet_code_76;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/24 17:16
 * @Desc :
 */
public class Test1 {
    public static void main(String[] args) {
        String s = "bba";
        String t = "ab";// ba
        MinWindow minWindow = new MinWindow();
        String result = minWindow.minWindow7(s, t);
        System.out.println("result :"+result);
    }
}

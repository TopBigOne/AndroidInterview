package stack.leet_code_224;

/**
 * @author : dev
 * @version :
 * @Date :  2021/3/29 21:30
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        String s = "(1+(4+5+2)-3)+(6+8)";
        int result = calculate.calculate(s);
        System.out.println("result : "+result);

    }
}

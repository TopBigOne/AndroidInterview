package stack.leet_code_1249;

/**
 * @author : dev
 * @version :
 * @Date :  2021/3/24 21:05
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        MinRemoveToMakeValid makeValid = new MinRemoveToMakeValid();
        String s = "lee(t(c)o)de)";
        String result = makeValid.minRemoveToMakeValid2(s);
        System.out.println("result: "+result);
    }
}

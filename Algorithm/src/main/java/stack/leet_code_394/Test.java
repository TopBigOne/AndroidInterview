package stack.leet_code_394;

/**
 * @author : dev
 * @version :
 * @Date :  3/9/21 9:20 PM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        DecodeString decode = new DecodeString();
        String raw = "3[a2[c]]";
        String result = decode.decodeString(raw);
        System.out.println("result : "+result);
    }
}

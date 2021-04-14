package stack.leet_code_946;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/4 23:41
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};

        ValidateStackSequences test = new ValidateStackSequences();

        boolean result = test.validateStackSequences3(pushed, popped);
        System.out.println("result: " + result);


    }
}

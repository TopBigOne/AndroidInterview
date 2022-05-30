package single_invoke_stack.leet_code_42;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/20 19:21
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Trap3 trap3 = new Trap3();
        int result = trap3.trap3(height);
        System.out.println("result : " + result);
    }

    private static void test2() {


    }
}

package stack.single_invoke_stack.offer_33;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/9/19 20:04
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {4, 8, 6, 12, 16, 14, 10};
        VerifyPostorder verifyPostorder = new VerifyPostorder();
        boolean result = verifyPostorder.verifyPostorder(nums);
        System.out.println("result : " + result);

    }
}

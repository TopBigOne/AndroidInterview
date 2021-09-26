package stack.single_invoke_stack.leet_code_654;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/9/24 00:00
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class Test {

    static int[] nums = {3, 2, 1, 6, 0, 5};
    static int len = nums.length;
    static ConstructMaximumBinaryTree constructMaximumBinaryTree;

    static {
        constructMaximumBinaryTree = new ConstructMaximumBinaryTree();

    }

    public static void main(String[] args) {
        testMax();
    }

    private static void testMax() {
        int index = constructMaximumBinaryTree.max(nums, 0, len);
        System.out.println("index : " + index);
    }


}

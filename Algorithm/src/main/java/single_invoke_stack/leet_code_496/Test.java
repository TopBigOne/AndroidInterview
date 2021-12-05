package single_invoke_stack.leet_code_496;

import java.util.Arrays;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/5 18:19
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class Test {
    public static void main(String[] args) {
        int [] nums1= {4,1,2};
        int [] nums2= {1,3,4,2};
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        int[] result = nextGreaterElement.nextGreaterElement(nums1, nums2);
        System.out.println("result :"+ Arrays.toString(result));

    }

}

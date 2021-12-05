package single_invoke_stack.leet_code_503;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/5 17:48
 * @Url : https://leetcode-cn.com/problems/next-greater-element-i/
 * @Level :  easy
 * @Desc :
 * @Counter :
 * @Answer :  2
 */
public class NextGreaterElement2 {
    public static void main(String[] args) {
        NextGreaterElement2 nextGreaterElement = new NextGreaterElement2();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] result = nextGreaterElement.nextGreaterElement(nums1, nums2);
        System.out.println("result :"+ Arrays.toString(result));

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int length = nums2.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < length; j++) {
                if (nums1[i] == nums2[j]) {
                    while (!stack.isEmpty() && nums2[stack.peek()] < nums2[j]) {
                        int index = stack.pop();
                        result[index] = nums2[j];
                    }
                }
            }
            stack.push(i);
        }

        return result;

    }
}

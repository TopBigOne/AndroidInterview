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
        nextGreaterElement.nextGreaterElements(nums2);
    }

    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[length];
        Arrays.fill(result, -1);
        // length << 1 ,将length 加倍；
        for (int i = 0; i < length << 1; i++) {
            int modIndex = i % length;
            System.out.println("i : " + i + ", modIndex : " + modIndex);
            while (!stack.isEmpty() && nums[stack.peekLast()] < nums[modIndex]) {
                int index = stack.pollLast();
                result[index] = nums[modIndex];
            }


            stack.addLast(modIndex);

        }
        return result;

    }


}

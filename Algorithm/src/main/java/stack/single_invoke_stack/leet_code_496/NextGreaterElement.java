package stack.single_invoke_stack.leet_code_496;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author : dev
 * @version :
 * @Date :  2/17/21 12:38 AM
 * @Desc : 下一个更大元素（https://leetcode-cn.com/problems/next-greater-element-i/solution/）
 * 题解：https://leetcode-cn.com/problems/next-greater-element-i/solution/dan-diao-zhan-jie-jue-next-greater-number-yi-lei-w/
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>(16);
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                int j = stack.pop();
                // 此时nums2[j]<nums2[i]
                map.put(nums2[j], nums2[i]);
            }
            // 下标入栈
            stack.push(i);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>(16);
        Deque<Integer> stack = new LinkedList<>();
        int numLength1 = nums1.length;
        int numLength2 = nums2.length;
        for (int i = 0; i < numLength2; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                int j = stack.pop();
                map.put(nums2[j], nums2[i]);
            }
            stack.push(i);
        }

        int[] result = new int[numLength1];
        for (int i = 0; i < numLength1; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;

    }

    public int[] nextGreaterElement3(int[] nums1, int[] nums2) {
        // 做一个初始化的操作
        HashMap<Integer, Integer> map = new HashMap<>(16);
        LinkedList<Integer> stack = new LinkedList<>();
        int numLength1 = nums1.length;
        int numLength2 = nums2.length;

        for (int i = 0; i < numLength2; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                int j = stack.pop();
                map.put(nums2[j], nums2[i]);
            }
            stack.push(i);
        }

        int[] result = new int[numLength1];
        for (int i = 0; i < numLength1; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }

        return result;

    }

    public int[] nextGreaterElement4(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>(16);
        LinkedList<Integer> stack = new LinkedList<>();
        int numsLength1 = nums1.length;
        int numsLength2 = nums2.length;

        for (int i = 0; i < numsLength2; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                int j = stack.pop();
                map.put(nums2[j], nums2[i]);
            }
            stack.push(i);
        }

        int[] result = new int[numsLength1];
        for (int i = 0; i < numsLength1; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }

    public int[] nextGreaterElement5(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>(16);
        LinkedList<Integer> stack = new LinkedList<>();
        int numsLength1 = nums1.length;
        int numsLength2 = nums2.length;
        for (int i = 0; i < numsLength2; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                int popVaule = stack.size();
                map.put(nums2[popVaule], nums2[i]);
            }
            stack.push(i);
        }

        int[] result = new int[numsLength1];
        for (int i = 0; i < numsLength1; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }

    public int[] nextGreaterElement6(int[] nums1, int[] nums2) {
        int numsLength1 = nums1.length;
        int numsLength2 = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>(16);
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < numsLength2; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                int popValue = stack.pop();
                map.put(nums2[popValue], nums2[i]);
            }
            stack.push(i);
        }

        int[] result = new int[numsLength1];
        for (int i = 0; i < numsLength1; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }

        return result;

    }

    public int[] nextGreaterElement7(int[] nums1, int[] nums2) {
        int numsLength1 = nums1.length;
        int numsLength2 = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>(16);
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < numsLength2; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                int popValue = stack.pop();
                map.put(nums2[popValue], nums2[i]);
            }
            stack.push(i);
        }

        int[] result = new int[numsLength1];
        for (int i = 0; i < numsLength1; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);

        }
        return result;
    }

    public int[] nextGreaterElement8(int[] nums1, int[] nums2) {
        int numsLength1 = nums1.length;
        int numsLength2 = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>(16);
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < numsLength2; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                int popValue = stack.pop();
                map.put(nums2[popValue], nums2[i]);

            }
            stack.push(i);
        }

        int[] result = new int[numsLength1];
        for (int i = 0; i < numsLength1; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }


}

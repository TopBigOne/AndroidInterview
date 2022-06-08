package top_k.leet_code_215;

import top_k.leet_code_215.base.BaseFun;

import java.util.PriorityQueue;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/5/31 20:43
 * @Url : https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * @Level : easy medium hard
 * @Desc :  数组中的第K个最大元素
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/
 * 使用优先队列解法
 */
public class FindKthLargest5 extends BaseFun {

    /**
     * 根据k的不同，选最大堆和最小堆，目的是让堆中的元素更小
     * ------------------------------------------------
     * 思路1： k 要是更靠近0的话，此时k就是一个较小的数，用最大堆；
     * 例如在一个有6个元素的数组里面，找第5 大元素
     * 思路2： k要是更靠近len的话，用最小堆；
     * 所以，分界点就是k = len-k;
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        if (k <= len - k) {
            System.out.println("使用最小堆：");
            // 特例：k= 1;用容量为k的最小堆
            // 使用一个含有k个元素的最小堆
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> a - b);
            for (int i = 0; i < k; i++) {
                minHeap.add(nums[i]);
            }
            for (int i = k; i < len; i++) {
                Integer topElement = minHeap.peek();
                if (topElement==null) {
                    continue;
                }
                if (nums[i] > topElement) {
                    minHeap.poll();
                    minHeap.add(nums[i]);

                }

            }
            return minHeap.peek();
        }


        System.out.println("使用最大堆：");
        assert k > len - k;
        // 特列：开100；用量为len-k+1 的最大堆
        int capacity = len - k + 1;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(capacity, (a, b) -> b - a);
        for (int i = 0; i < capacity; i++) {
            maxHeap.add(nums[i]);
        }

        for (int i = capacity; i < len; i++) {
            // 看一眼，不拿出，因为有可能没有必要交换
            Integer topElement = maxHeap.peek();
            // 只要当前遍历的元素比堆顶元素大，堆顶弹出，遍历的元素进去
            if (nums[i] < topElement) {
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }
        }
        return maxHeap.peek();



    }

}

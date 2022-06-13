package top_k.leet_code_347;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/12 16:41
 * @Url : https://leetcode-cn.com/problems/top-k-frequent-elements/
 * @Level :  medium
 * @Desc : 前 K 个高频元素
 * @Counter : 10
 * @Answer : https://leetcode-cn.com/problems/top-k-frequent-elements/solution/4-chong-fang-fa-miao-sha-topkji-shu-pai-xu-kuai-pa/
 */
public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = {9, 8, 8, 8, 8, 5, 5, 6, 6, 6, 6, 2, 3};
        TopKFrequent topKFrequent = new TopKFrequent();
        topKFrequent.topKFrequent(nums, 2);
    }

    public int[] topKFrequent(int[] nums, int k) {
        // 1: base corner
        if (nums == null) {
            return null;
        }
        // 2:统计数量
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            // 2-1: 每出现一次，就
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 2: 做排序，按照出现的频率，从大到小排列
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());

        // 3： 对list做截取，注意subList()前闭后开
        list = list.subList(0, k);

        // 4： 结果数组
        int[] result = new int[k];
        int index = 0;
        // 5:遍历Map.Entry，将其key放入数组result中
        for (Map.Entry<Integer, Integer> entry : list) {
            result[index++] = entry.getKey();
        }
        return result;
    }

    public int[] topKFrequent2(int[] nums, int k) {

        int[] result = new int[k];

        int length;
        if (nums == null || (length = nums.length) == 0) {
            return result;
        }

        Arrays.sort(nums);


        return result;


    }

    public int[] topKFrequent3(int[] nums, int k) {
        // 统计每个数字出现的次数
        Map<Integer, Integer> counter = IntStream.of(nums).boxed().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
        // 定义小根堆，根据数字频率自小到大排序
        Queue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(counter::get));
        // 遍历数组，维护一个大小为 k 的小根堆：
        // 不足 k 个直接将当前数字加入到堆中；否则判断堆中的最小次数是否小于当前数字的出现次数，若是，则删掉堆中出现次数最少的一个数字，将当前数字加入堆中。
        counter.forEach((num, cnt) -> {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (counter.get(pq.peek()) < cnt) {
                pq.poll();
                pq.offer(num);
            }
        });
        // 构造返回结果
        int[] res = new int[k];
        int idx = 0;
        for (int num : pq) {
            res[idx++] = num;
        }
        return res;
    }


}




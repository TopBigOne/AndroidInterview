package tree.leet_code_715;

import java.util.TreeMap;

/**
 * @author : dev
 * @version :
 * @Date :  12/20/21 8:14 PM
 * @Desc : Rangle 模块
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/range-module/
 *
 * 题解：https://leetcode-cn.com/problems/range-module/solution/sui-shou-ban-yun-yi-ge-jie-ba-zi-ji-xie-de-tai-la-/
 */
public class RangeModule {

    TreeMap<Integer, Integer> intervals = new TreeMap<>();

    public void addRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        Integer end = intervals.floorKey(right);
        //存在比left小的左边界，并且右边界大于left
        if (start != null && intervals.get(start) >= left) {
            //确定左边界
            left = start;
        }
        //存在比right小的左边界，并且右边界比right大
        if (end != null && intervals.get(end) > right) {
            //确定右边界
            right = intervals.get(end);
        }
/*情况汇总: 若已添加过边界值的treemap，包含[4,8）与 [11,15]，在此范围下有9种情况，以下列出3种：
1. 添加范围为[6,9), 则存在比6小的左边界[4,8),同时8>6,导致left=4; 由于start!=null,则end!=null
	(4同样小于9)，end=4, 所以intervals.get(end) > right不成立，right值不变，map范围更新为[4,9),[11,15)
2. 添加范围为[6,12), 则存在比6小的左边界[4,8),同时8>6,导致left=4; end!=null (11小于12)，end=11,
	所以intervals.get(end) > right成立，right值扩大，map范围更新为[4,15)
3. 添加范围为[9,12), 则存在比9小的左边界[4,8),start=4, 但intervals.get(start) >= left不成立，
	left依然为9; end!=null (11小于12)，end=11, 所以intervals.get(end) > right (15>12) 成立，
	right值扩大，map范围更新为[4,8),[9,15)
*/
        //start与end均为空，意味着没有区间比当前范围更小
        intervals.put(left, right);
        //根据key值清理小区间，刚放入了（left,right)，因此清除时不能包含左边界点
        intervals.subMap(left, false, right, true).clear();
    }

    public boolean queryRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        return start != null && intervals.get(start) >= right;
    }

    public void removeRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        Integer end = intervals.floorKey(right);

        if (end != null && intervals.get(end) > right) {
            intervals.put(right, intervals.get(end));
        }
        if (start != null && intervals.get(start) > left) {
            intervals.put(start, left);
        }
        //清除左边界，保留右边界
        intervals.subMap(left, true, right, false).clear();
    }

}

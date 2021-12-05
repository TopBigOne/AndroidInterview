package array.leet_code_448;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/3 23:13
 * @Url :
 * @Level :  easy
 * @Desc :  找到所有数组中消失的数字
 * @Counter :
 * @Answer :https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/solution/shou-hua-tu-jie-jiao-huan-shu-zi-zai-ci-kzicg/
 */
public class FindDisappearedNumbers {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        FindDisappearedNumbers findDisappearedNumbers = new FindDisappearedNumbers();
        List<Integer> result = findDisappearedNumbers.findDisappearedNumbers(nums);
        System.out.println("result : " + result);

    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> temp = new HashSet<>();

        for (int num : nums) {
            temp.add(num);
        }
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            if (!temp.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int length = nums.length;
        List<Integer> res = new ArrayList<>();
        int index = 0;
        while (index < length) {
            if (nums[index] == index + 1) {
                index++;
                continue;
            }
            int idealIdx = nums[index] - 1;
            if (nums[index] == nums[idealIdx]) {
                index++;
                continue;
            }

            int temp = nums[index];
            nums[index] = nums[idealIdx];
            nums[idealIdx] = temp;
        }

        for (int j = 0; j < length; j++) {
            if (nums[j] != j + 1) {
                res.add(j + 1);
            }
        }
        return res;

    }

    public List<Integer> findDisappearedNumbers3(int[] nums) {
        int length = nums.length;
        List<Integer> res = new ArrayList<>();
        int index = 0;
        while (index < length) {
            if (nums[index] == index + 1) {
                index++;
                continue;
            }

            int idealIdx = nums[index] - 1;
            if (nums[index] == nums[idealIdx]) {
                index++;
                continue;
            }
            int temp = nums[index];
            nums[index] = nums[idealIdx];
            nums[idealIdx] = temp;
        }

        for (int i = 0; i < length; i++) {
            int temp = 0;
            if (nums[i] != (temp = i + 1)) {
                res.add(temp);

            }
        }
        return res;
    }

    public List<Integer> findDisappearedNumbers4(int[] nums) {
        int length = nums.length;
        ArrayList<Integer> res = new ArrayList<>();
        int index = 0;
        while (index < length) {
            if (nums[index] == index + 1) {
                index++;
                continue;
            }
            int idealIdx = nums[index] - 1;
            if (nums[index] == nums[idealIdx]) {
                index++;
                continue;
            }
            int temp = nums[index];
            nums[index] = nums[idealIdx];
            nums[idealIdx] = temp;
        }
        for (int i = 0; i < length; i++) {
            int temp = 0;
            if (nums[i] != (temp = i + 1)) {
                res.add(temp);
            }
        }
        return res;
    }

    public List<Integer> findDisappearedNumbers5(int[] nums) {
        int index = 0;
        int lenth = nums.length;
        List<Integer> res = new ArrayList<>();
        while (index < lenth) {
            if (nums[index] == index + 1) {
                index++;
                continue;
            }
            int idealIdx = nums[index] - 1;
            if (nums[idealIdx] == nums[index]) {
                index++;
                continue;
            }

            int temp = nums[index];
            nums[index] = nums[idealIdx];
            nums[idealIdx] = temp;
        }

        for (int i = 0; i < lenth; i++) {
            int temp = 0;
            if (nums[i] != (temp = i + 1)) {
                res.add(temp);
            }
        }
        return res;
    }
}

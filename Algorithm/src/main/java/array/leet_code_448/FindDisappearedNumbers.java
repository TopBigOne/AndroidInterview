package array.leet_code_448;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javafx.scene.control.MenuItem;
import javafx.scene.control.TableRow;
import string.leet_code_38.CountAndSay;
import sun.lwawt.macosx.CInputMethod;
import tree.leet_code_872.LeafSimilar;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/3 23:13
 * @Url : https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/solution/
 * @Level :  easy
 * @Desc :  找到所有数组中消失的数字
 * @Counter :
 * @Answer :https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/solution/shou-hua-tu-jie-jiao-huan-shu-zi-zai-ci-kzicg/
 */
public class FindDisappearedNumbers {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        FindDisappearedNumbers findDisappearedNumbers = new FindDisappearedNumbers();
        List<Integer> result = findDisappearedNumbers.findDisappearedNumbers8(nums);
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

    public List<Integer> findDisappearedNumbers6(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        int length = nums.length;

        while (i < nums.length) {
            if (nums[i] == i + 1) {
                i++;
                continue;
            }

            int idealIdx = nums[i] - 1;
            if (nums[i] == nums[idealIdx]) {
                i++;
                continue;
            }

            int temp = nums[i];
            nums[i] = nums[idealIdx];
            nums[idealIdx] = temp;
        }

        for (int j = 0; j < length; j++) {
            if (nums[j] != j + 1) {
                res.add(j + 1);
            }
        }
        return res;
    }

    public List<Integer> findDisappearedNumbers7(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int length = nums.length;
        int i = 0;
        while (i < length) {
            if (nums[i] == i + 1) {
                i++;
                continue;
            }
            int idealIndex = nums[i] - 1;
            if (nums[i] == nums[idealIndex]) {
                i++;
                continue;
            }
            int temp = nums[i];
            nums[i] = nums[idealIndex];
            nums[idealIndex] = temp;

        }
        for (int j = 0; j < length; j++) {
            if (nums[j] != j + 1) {
                res.add(j + 1);
            }
        }
        return res;

    }

    /**
     * 我喜欢的解法
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers8(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int length = nums.length;
        for (int i = 1; i <= length; i++) {
            if (!set.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }

    public List<Integer> findDisappearedNumbers9(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int length = nums.length;
        int i = 0;
        while (i < length) {
            if (nums[i] == i + 1) {
                i++;
                continue;
            }
            int idealIndex = nums[i] - 1;
            if (nums[i] == nums[idealIndex]) {
                i++;
                continue;
            }
            int temp = nums[i];
            nums[i] = nums[idealIndex];
            nums[idealIndex] = temp;
        }

        for (int j = 0; j < length; j++) {
            if (nums[j] != j + 1) {
                res.add(j + 1);
            }

        }

        return res;

    }

}

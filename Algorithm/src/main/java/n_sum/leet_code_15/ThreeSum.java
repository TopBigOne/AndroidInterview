package n_sum.leet_code_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author :  dev
 * @version :
 * @Date :  24/27/21 9:37 PM
 * @Url : https://leetcode-cn.com/problems/3sum/
 * @Level :  medium
 * @Desc : 三数之和
 * @Counter : 38
 * @Answer :
 */
public class ThreeSum {
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }

        int len = nums.length;

        if (len < 3) return ans;

        Arrays.sort(nums); // 排序

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环

            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重

            // 令左指针 L=i+1
            int L = i + 1;
            // 右指针 R=n-1
            int R = len - 1;

            //，当 L<R 时，执行循环
            while (L < R) {
                // 计算sum值
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));

                    // 当 nums[i]+nums[L]+nums[R]==0，执行循环，
                    // 判断左界和右界是否和下一位置重复，去除重复解
                    while (L < R && nums[L] == nums[L + 1]) L++; // 去重
                    while (L < R && nums[R] == nums[R - 1]) R--; // 去重

                    // 并同时将 L,R 移到下一位置，寻找新的解
                    L++;
                    R--;
                    continue;
                }

                // 若和小于 0，说明 nums[L] 太小，L 右移
                if (sum < 0) {
                    L++;
                    continue;
                }

                // 若和大于 0，说明 nums[R] 太大，R 左移
                if (sum > 0) {
                    R--;
                }

            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int length;
        // 1: base corner
        if (nums == null || (length = nums.length) == 0 || length < 3) {
            return ans;
        }
        // 2:排序
        Arrays.sort(nums);

        // 3:遍历数组
        for (int i = 0; i < length; i++) {
            // 3-1: 如果当前数字大于0 ，那么三数之和大于0 ，所以结束循环（我问：3，-3，0，这三个数不行吗？）
            if (nums[i] > 0) {
                break;
            }
            // 3-2 : 去重,nums[i] == nums[i - 1]，当前的数字，和前面的一个数字相等；
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 3-3 : left ;
            int left = i + 1;
            // 3-4 : right;
            int rigth = length - 1;
            // 3-5 : 当前left < right 开始循环
            while (left < rigth) {
                //  三数之和
                int sum = nums[i] + nums[left] + nums[rigth];

                // 3-6 ：  小于0 ，num[left] 的值太小，left指针需要往右移动
                if (sum < 0) {
                    left++;
                    continue;
                }
                // 3-7 ： sum>0 ,说明num[right] 的值太大，right指针，需要往左边移动
                if (sum > 0) {
                    rigth--;
                    continue;
                }
                // 3-8：正好等于0，很大程度上就是我们想要的值
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[rigth]));
                    // 3-9：再次做去重操作
                    // a:判断左界和右界是否和下一位置重复，去除重复解
                    while (left < rigth && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // b: 右边
                    while (left < rigth && nums[rigth] == nums[rigth - 1]) {
                        rigth--;
                    }
                    // 3-10 : left 和 right指针右移，便于下次循环
                    left++;
                    rigth--;
                    continue;
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length;
        // 1: base
        if (nums == null || (length = nums.length) == 0 || length < 3) {
            return result;
        }
        // 2: 排序
        Arrays.sort(nums);
        // 3: 遍历数组
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                    continue;
                }
                if (sum > 0) {
                    right--;
                    continue;
                }
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while ((left < right && nums[right] == nums[right - 1])) {
                        right--;
                    }
                    left++;
                    right--;
                    continue;
                }
            }
        }

        return result;
    }

    public List<List<Integer>> threeSum4(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length;
        // 1: base corner
        if (nums == null || (length = nums.length) == 0 || length < 3) {
            return result;
        }
        // 2: 排序
        Arrays.sort(nums);

        // 3: 遍历数组
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum < 0) {
                    left++;
                    continue;
                }
                if (sum > 0) {
                    right--;
                    continue;
                }
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 做一下去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                    continue;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum5(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length;
        // base corner
        if (nums == null || (length = nums.length) == 0 || length < 3) {
            return result;
        }
        // do a sort
        Arrays.sort(nums);

        // do the loop;
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                    continue;
                }
                if (sum > 0) {
                    right--;
                    continue;
                }

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 做一下去重
                    while (left < right && nums[left] == nums[left++]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right--]) {
                        right--;
                    }
                    // 左边向右边移动
                    // 右边向左移动
                    left++;
                    right--;
                    continue;
                }
            }
        }
        return result;
    }


}

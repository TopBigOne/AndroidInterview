package string.leet_code_167;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/12 20:04
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(nums, 9);
        System.out.println("result：" + Arrays.toString(result));

    }

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < numbers.length; index++) {
            int value = target - numbers[index];
            if (map.containsKey(value)) {
                result[0] = index + 1;
                result[1] = map.get(value) + 1;
                break;
            }
            map.put(numbers[index], index);
        }
        Arrays.sort(result);

        return result;


    }
}

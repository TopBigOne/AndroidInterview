package array;

/**
 * @author : dev
 * @version :
 * @Date :  2/22/21 1:57 PM
 * @Desc : 不使用 for 循环，找出数组中最大数
 *
 *
 */
public class FindMaNumWithoutFor {
    int[] rawsData = {4, 6, 4, 1, 3, 7, 9, 0, 33, 21, 8};
    int length = rawsData.length;
    int max = Integer.MIN_VALUE;

    void findMax(int index) {
        if (rawsData[index] > max) {
            max = rawsData[index];
        }
        if (index < length - 1) {
            // 利用递归，代替了循环
            findMax(index + 1);
        } else {
            System.err.println("max value : " + max);
        }
    }

    public static void main(String[] args) {
        FindMaNumWithoutFor findMaNumWithoutFor = new FindMaNumWithoutFor();
        findMaNumWithoutFor.findMax(0);

    }
}

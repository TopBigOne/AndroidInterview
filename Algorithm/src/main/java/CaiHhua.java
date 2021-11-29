import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  11/25/21 5:02 PM
 * @Desc :
 * <p>
 * 一个无序数组{0.2.0.1.1.2.0.1……}只包含0，1和2。请编写一段程序实现，从小到大规则排序。输出{0.0.0.1.1.1.2.2……}
 */
public class CaiHhua {
    public static void main(String[] args) {
        int[] nums = {0, 2, 0, 1, 1, 2, 0, 1};
        CaiHhua caiHhua = new CaiHhua();
        caiHhua.doSort(nums);

        // 有难度的题
        String strs = "0.2.0.1.1.2.0.1.1.1.0.0.0.0.2.2.2.2";
        caiHhua.doSort(strs);

    }



    public void doSort(String nums) {
        System.out.println("原始数据为 ：");

    }

    public void doSort(int[] nums) {
        System.out.println("数组为 int 类型：");
        System.out.println("原始数组 ：" + Arrays.toString(nums));
        Arrays.sort(nums);
        System.out.println("排序后数组：" + Arrays.toString(nums));
    }



}

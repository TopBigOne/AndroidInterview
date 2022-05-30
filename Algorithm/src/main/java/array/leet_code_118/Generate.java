package array.leet_code_118;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/25 15:54
 * @Desc : 杨辉三角
 * <p>
 * https://leetcode.cn/problems/pascals-triangle/submissions/
 */
public class Generate {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {

            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // j == 0：左边的变；
                // j ==i : 右边的变；
                if (j == 0 || j == i) {
                    subList.add(1);
                } else {
                    // 上一行的数据
                    List<Integer> preList = result.get(i - 1);
                    int value = preList.get(j - 1) + preList.get(j);
                    subList.add(value);
                }
            }
            result.add(subList);
        }
        return result;
    }
}

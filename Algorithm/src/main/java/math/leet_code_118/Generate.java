package math.leet_code_118;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  12/18/21 10:50 PM
 * @Desc :  https://leetcode-cn.com/problems/pascals-triangle/
 * <p>
 * https://leetcode-cn.com/problems/pascals-triangle/solution/qu-qiao-jie-fa-cuo-yi-wei-zai-zhu-ge-xiang-jia-28m/
 */
public class Generate {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);

        res.add(firstRow);
        int size = res.size();
        while (size < numRows) {
            LinkedList<Integer> first = new LinkedList<>();
            first.addFirst(0);
            LinkedList<Integer> second = new LinkedList<>();
            second.addLast(0);
            for (int x : res.get(size - 1)) {
                first.addFirst(x);
                second.addLast(x);
            }
            List<Integer> newRow = new ArrayList<>();
            for (int i = 0; i < first.size(); i++) {
                newRow.add(first.get(i) + second.get(i));
            }
            res.add(newRow);
            size++;
        }
        return res;

    }
}

package array.leet_code_119;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/25 16:31
 * @Desc :
 */
public class GetRow {
    public static void main(String[] args) {
        GetRow getRow = new GetRow();
        List<Integer> result = getRow.getRow(3);
        // System.out.println("result : " + result);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    int val = pre.get(j - 1) + pre.get(j);
                    temp.add(val);
                }
            }

            System.out.println("temp : " + temp);
            pre = temp;

        }
        return pre;


    }
}

package math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/22 10:12
 * @Url :
 * @Level :
 * @Desc : 求 200~300 之间的素数
 * @Counter :
 * @Answer :
 */
public class SuShu {
    public static void main(String[] args) {
        SuShu suShu = new SuShu();
        System.out.println("suShu : " + suShu.getSu(200, 300));
    }

    public List<Integer> getSu(int start, int end) {
        List<Integer> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    break;
                }
                if (i == j + 1) {
                    result.add(i);
                }
            }
        }
        return result;
    }

    public List<Integer> getSu(int start, int end) {
        List<Integer> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            for (int j = 2; j < i,j++){
                // 被一个数整除了，ps:这个数不是1 和 i 本身哦
                // 那就终止循环
                if (i % j == 0) {
                    break;
                }

                if (i = j + 1) {
                    result.add(i);
                }

            }
        }

        return result;
    }
}

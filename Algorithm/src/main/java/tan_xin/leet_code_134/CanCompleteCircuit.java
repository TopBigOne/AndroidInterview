package tan_xin.leet_code_134;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/16 23:44
 * @Url : https://leetcode-cn.com/problems/gas-station/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/gas-station/solution/shi-yong-tu-de-si-xiang-fen-xi-gai-wen-ti-by-cyayc/
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/gas-station/solution/134-jia-you-zhan-tan-xin-jing-dian-ti-mu-xiang-jie/
 */
public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }

        return spare < 0 ? -1 : (minIndex + 1) % len;

    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }
        return spare < 0 ? -1 : (minIndex + 1) % len;

    }
}

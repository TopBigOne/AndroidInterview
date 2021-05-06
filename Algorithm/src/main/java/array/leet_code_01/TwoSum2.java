package array.leet_code_01;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : dev
 * @version :
 * @Date :  5/1/21 5:00 PM
 * @Desc :
 * <p>
 * 稍微的改变一下 two sum 问题
 */
public class TwoSum2 {
    Map<Integer, Integer> freq = new HashMap<>();

    /**
     * 向数据结构中添加一个数
     *
     * @param numbber
     */
    public void add(int numbber) {
        // 记录number 出现的次数
        freq.put(numbber, freq.getOrDefault(numbber, 0) + 1);

    }

    /**
     * 寻找当前 数据结构中是否存在两个数的和为 value
     *
     * @param value
     * @return
     */
    public boolean find(int value) {
        for (Integer key : freq.keySet()) {
            int other  = value-key;
            // case 1:
            if(other==key&&freq.get(key)>1){
                return true;
            }
            // case 2:
            if(other!=key&&freq.containsKey(other)){
                return true;

            }
        }

        return false;
    }

}

package array.leet_code_506;

import java.util.*;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/2 22:18
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class FindRelativeRanks {
    public static void main(String[] args) {
       // int[] s = {10, 3, 8, 9, 4};
        // ["Bronze Medal","Silver Medal","Gold Medal"]
        int[] s = {100,111,111111};
        FindRelativeRanks findRelativeRanks = new FindRelativeRanks();
        findRelativeRanks.findRelativeRanks(s);
    }

    /**
     * 有点low，但是解答出来了；
     * @param score
     * @return
     */
    public String[] findRelativeRanks(int[] score) {

        int length = score.length;
        Map<Integer, Integer> rawMap = new HashMap<>();
        for (int index = 0; index < length; index++) {
            rawMap.put(score[index], index);
        }
        TreeSet<Integer> treeSet = new TreeSet<>(rawMap.keySet());
        Map<Integer, String> map1 = new HashMap<>();
        List<Integer> indexs = new ArrayList<>(treeSet);

        Collections.reverse(indexs);
        System.out.println("final indexs:"+indexs);

        for (int i = 0; i < indexs.size(); i++) {
            int val = indexs.get(i);
            if (i == 0) {
                map1.put(val, "Gold Medal");
            } else if (i == 1) {
                map1.put(val, "Silver Medal");
            } else if (i == 2) {
                map1.put(val, "Bronze Medal");
            } else {
                map1.put(val, i+1 + "");
            }
        }


        String[] strs = new String[length];

        for (Map.Entry<Integer, String> entry : map1.entrySet()) {
            int key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key : " + key + ",  value :" + value);

            int rawIndex = rawMap.get(key);
            strs[rawIndex] =value;
        }
        System.out.println("result:"+ Arrays.toString(strs));


        return strs;


    }
}

package dp.leet_code_403;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/11/11 23:58
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class CanCross3 {
    Map<Integer,Integer> map = new HashMap<>();
    Map<String,Boolean> cache  = new HashMap<>();
    public boolean canCross(int [] ss){
        int length = ss.length;
        for (int i = 0; i < length; i++) {
            map.put(ss[i],i);
        }
        // check first step
        if(!map.containsKey(1)){
            return false;
        }
        return dfs(ss,length,1,1);
    }

    private boolean dfs(int[] ss, int length, int u, int k) {
        String key = u+"_"+k;
        if(cache.containsKey(key)){
            return  cache.get(key);
        }

        if(u==length-1){
            return true;
        }
        for(int i = -1;i<=1;i++){
            // 原地踏步走，直接跳过
            if(k+i==0) continue;
            // 下一步的石头理论编号
            int next = ss[u]+ k+i;
            // 如果存在下一步的石头，则跳转到下一步石头，并DFS 下去
            if(map.containsKey(next)){
                boolean cur = dfs(ss,length,map.get(next),k+i);
                cache.put(key,cur);
                if(cur){
                    return true;
                }
            }
        }
        cache.put(key,false);
        return false;
    }
}

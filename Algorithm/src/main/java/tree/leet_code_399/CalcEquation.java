package tree.leet_code_399;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/24 16:17
 * @Desc : 除法求职：https://leetcode.cn/problems/evaluate-division/
 */
public class CalcEquation {

    //图，用哈希map来存节点关系和比值，比值存放在后一个节点里
    //<"a", ("b", 2.0)> 表示a/b=2.0
    Map<String, List<Pair>> map = new HashMap<>();

    //保存最终结果
    List<Double> res = new ArrayList<>();

    //标记当前问题是否有答案，用于在dfs中如果找到答案了就提前返回
    boolean isFound = false;

    //标记一次dfs中节点是否已经走过，走过的节点就加入set，回溯以后再去掉该节点
    Set<String> visited = new HashSet<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        //构建图
        for (int i = 0; i < equations.size(); i++) {
            List<Pair> list1 = map.getOrDefault(equations.get(i).get(0), new ArrayList<>());
            list1.add(new Pair(equations.get(i).get(1), values[i]));
            //首次添加
            if (list1.size() == 1) {
                map.put(equations.get(i).get(0), list1);
            }

            List<Pair> list2 = map.getOrDefault(equations.get(i).get(1), new ArrayList<>());
            list2.add(new Pair(equations.get(i).get(0), 1 / values[i]));
            //首次添加
            if (list2.size() == 1) {
                map.put(equations.get(i).get(1), list2);
            }
        }

        //对queries中每个问题里的每个变量进行dfs
        for (int i = 0; i < queries.size(); i++) {
            //图中没有该节点，结果直接置为-1
            if (!map.containsKey(queries.get(i).get(0))) {
                res.add(-1.0);
                continue;
            }

            //每个新query开始前先重新置为false，表面还没找到答案
            isFound = false;

            //从当前变量节点开始dfs，注意标记节点是否走过
            visited.add(queries.get(i).get(0));
            dfs(queries.get(i).get(0), queries.get(i).get(1), 1.0);
            visited.remove(queries.get(i).get(0));

            //从当前变量出发没有找到路径，结果-1.0（如果找到了isFound会为true）
            if (!isFound) {
                res.add(-1.0);
            }

        }

        //放double数组里返回
        double[] r = new double[queries.size()];
        for (int i = 0; i < r.length; i++) {
            r[i] = res.get(i);
        }

        return r;
    }

    /**
     * dfs
     *
     * @param start
     * @param target
     * @param weight
     */
    public void dfs(String start, String target, double weight) {
        //之前的dfs里已经找到了直接返回
        if (isFound) {
            return;
        }

        //找到
        if (start.equals(target)) {
            res.add(weight);
            isFound = true;
            return;
        }

        //遍历当前start的所有邻居
        for (Pair p : map.get(start)) {
            //注意这里不是判key存在，而是判value是否为true
            //该邻居已经走过则继续遍历下一个邻居
            if (visited.contains(p.val)) {
                continue;
            }
            visited.add(p.val);
            dfs(p.val, target, weight * p.div);
            visited.remove(p.val);
        }

    }

    /**
     * 存储节点和对应比值
     */
    class Pair {
        String val;
        double div;

        public Pair() {
        }

        public Pair(String val, double div) {
            this.val = val;
            this.div = div;
        }
    }
}
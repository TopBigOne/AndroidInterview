package bing_cha_ji.rt;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/28 23:40
 * @Desc :
 * https://leetcode.cn/problems/number-of-provinces/solution/python-duo-tu-xiang-jie-bing-cha-ji-by-m-vjdr/
 */
public class FindCircleNum {

    public int findCircleNum(int[][] isConnected) {
        UnionFind uf = new UnionFind();
        for (int i = 0; i < isConnected.length; i++) {
            uf.add(i);
            for (int j = 0; j < i; j++) {
                if (isConnected[i][j] == 1) {
                    uf.merge(i, j);
                }
            }
        }

        return uf.getNumOfSets();
    }

    static class UnionFind {
        // 记录父节点
        private final Map<Integer, Integer> father;
        // 记录集合的数量
        private int numOfSets = 0;

        public UnionFind() {
            father = new HashMap<>();
            numOfSets = 0;
        }

        public void add(int x) {
            if (!father.containsKey(x)) {
                father.put(x, null);
                numOfSets++;
            }
        }

        public void merge(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                father.put(rootX, rootY);
                numOfSets--;
            }
        }

        public int find(int x) {
            int root = x;

            while (father.get(root) != null) {
                root = father.get(root);
            }

            while (x != root) {
                int original_father = father.get(x);
                father.put(x, root);
                x = original_father;
            }

            return root;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public int getNumOfSets() {
            return numOfSets;
        }
    }


}

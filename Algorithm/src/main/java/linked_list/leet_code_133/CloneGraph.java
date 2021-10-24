package linked_list.leet_code_133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/22 23:29
 * @Url : https://leetcode-cn.com/problems/clone-graph/
 * @Level :     medium
 * @Desc : 克隆图  给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/clone-graph/solution/dfs-he-bfs-by-powcai/
 */
public class CloneGraph {
    public Node cloneGraph(Node node) {
        Map<Node, Node> lookMap = new HashMap<>();
        return dfs(node, lookMap);
    }

    private Node dfs(Node node, Map<Node, Node> lookup) {
        if (node == null) return null;
        if (lookup.containsKey(node)) return lookup.get(node);
        Node clone = new Node(node.val, new ArrayList<>());
        lookup.put(node, clone);
        for (Node n : node.neighbors) {
            clone.neighbors.add(dfs(n, lookup));
        }
        return clone;
    }
}

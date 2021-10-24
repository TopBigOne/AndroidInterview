package linked_list.leet_code_133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/23 23:06
 * @Url : https://leetcode-cn.com/problems/clone-graph/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class CloneGraph2 {
    public Node cloneGraph(Node node) {
        Map<Node, Node> lookMap = new HashMap<>();
        return dfs(node, lookMap);
    }

    private Node dfs(Node node, Map<Node, Node> lookMap) {
        if (node == null) return null;
        if (lookMap.containsKey(node)) {
            return lookMap.get(node);
        }
        Node clone = new Node(node.val, new ArrayList<>());
        lookMap.put(node, clone);
        for (Node n : node.neighbors) {
            clone.neighbors.add(dfs(n, lookMap));
        }
        return clone;
    }


}

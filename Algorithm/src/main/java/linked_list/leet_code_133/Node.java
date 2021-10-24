package linked_list.leet_code_133;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/22 23:30
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

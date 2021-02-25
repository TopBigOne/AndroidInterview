package tree.bfs.leet_code_429;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2/25/21 8:49 PM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {

        NTreeLevelOrder.Node root = new NTreeLevelOrder.Node(1);


        NTreeLevelOrder.Node node3 = new NTreeLevelOrder.Node(3);
        NTreeLevelOrder.Node node2 = new NTreeLevelOrder.Node(2);
        NTreeLevelOrder.Node node4 = new NTreeLevelOrder.Node(4);
        List<NTreeLevelOrder.Node> c1 = new ArrayList<>();
        c1.add(node3);
        c1.add(node2);
        c1.add(node4);

        node3.children = get3Children();
        root.children = c1;
        NTreeLevelOrder nTreeLevelOrder = new NTreeLevelOrder();
        List<List<Integer>> lists = nTreeLevelOrder.levelOrder(root);
        int a = 10;


    }

    private static List<NTreeLevelOrder.Node> get3Children() {
        NTreeLevelOrder.Node node5 = new NTreeLevelOrder.Node(5);
        NTreeLevelOrder.Node node6 = new NTreeLevelOrder.Node(6);
        List<NTreeLevelOrder.Node> c3 = new ArrayList<>();
        c3.add(node5);
        c3.add(node6);

        return c3;
    }
}

package linked_list.leet_code_382;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  1/16/22 9:53 AM
 * @Desc :   给你一个单链表，随机选择链表的一个节点，并返回相应的节点值。每个节点 被选中的概率一样 。
 * https://leetcode-cn.com/problems/linked-list-random-node/solution/
 * <p>
 * <p>
 * 题解:https://leetcode-cn.com/problems/linked-list-random-node/solution/gong-shui-san-xie-xu-shui-chi-chou-yang-1lp9d/
 */
public class Solution {
    List<Integer> list = new ArrayList<>();
    Random random = new Random(20220116);

    public Solution(ListNode head) {
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        int idx = random.nextInt(list.size());
        return list.get(idx);
    }

}

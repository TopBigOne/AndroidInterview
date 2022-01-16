import java.util.ArrayList;
import java.util.List;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  1/14/22 3:44 PM
 * @Desc :
 */
public class SingleLinklist {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next = new ListNode(5);
        doTest(l1);
    }

    //result : 3,5;
    private static void doTest(ListNode l1) {
        ListNode temp = l1;
        ListNode dummy =new ListNode(-1);
       // dummy.next = l1;
        List<ListNode> nodeList = new ArrayList<>();
        while (temp != null) {
            if (nodeList.contains(temp)) {
                nodeList.remove(temp);
            } else {
                nodeList.add(temp);
            }
            temp = temp.next;
        }
        int a = 10;


    }
}

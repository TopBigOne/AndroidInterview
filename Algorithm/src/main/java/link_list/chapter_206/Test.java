package link_list.chapter_206;

import link_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2/8/21 5:18 PM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        //  [1,2,3,4,5]
        ReverseLinkList reverseLinkList = new ReverseLinkList();
        ListNode one = new ListNode();
        one.val = 1;
        ListNode two = new ListNode();
        two.val = 2;
        ListNode three = new ListNode();
        three.val = 3;
        ListNode four = new ListNode();
        four.val = 4;
        ListNode five = new ListNode();
        five.val = 5;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        ListNode result = reverseLinkList.reverseList(one);
        int a = 10;

    }
}

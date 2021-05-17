package linked_list.leet_code_143;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/11 10:55
 * @Desc : 测试两个链表交替拼接
 */
public class Test2 {
    public void alternateMergeList() {
        ListNode headOne = new ListNode(1);
        headOne.next = new ListNode(2);
        headOne.next.next = new ListNode(3);
        headOne.next.next.next = new ListNode(4);

        ListNode headTwo = new ListNode(7);
        headTwo.next = new ListNode(6);
        headTwo.next.next = new ListNode(5);


        while (headTwo!=null){
          ListNode temp =  headTwo.next;

          headTwo.next = headOne.next;
          headOne.next = headTwo;
          headOne = headTwo.next;

          headTwo = temp;


        }





    }
}

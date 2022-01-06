package linked_list.leet_code_361;

import linked_list.ListNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/1/2 22:54
 * @Url : https://leetcode-cn.com/problems/plus-one-linked-list/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :
 * <p>
 *     题解：
 * https://leetcode-cn.com/problems/plus-one-linked-list/solution/c-kuai-man-zhi-zhen-bu-fan-zhuan-lian-biao-by-kao-/
 *
 * https://leetcode-cn.com/problems/plus-one-linked-list/solution/fu-xue-ming-zhu-qiu-jia-fa-xiang-xi-tu-j-rrs3/
 */
public class PlusOne {
    public ListNode plusOne(ListNode head) {

        //1.双指针
        ListNode fast = head;
        ListNode slow = new ListNode(0);
        slow.next = head;

        //2.遍历链表
        while (fast != null) {
            if (fast.val != 9) {
                slow = fast;
            }
            fast = fast.next;
        }

        //3.末位加1
        slow.val += 1;
        ListNode cur = slow.next;
        while (cur != null) {
            cur.val = 0;
            cur = cur.next;
        }
        return slow.next == head ? slow : head;



    }


}

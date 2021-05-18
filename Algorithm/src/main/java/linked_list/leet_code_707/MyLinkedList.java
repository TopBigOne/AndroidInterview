package linked_list.leet_code_707;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/18 15:42
 * @Desc : leetcode :707 : 设计链表：media：https://leetcode-cn.com/problems/design-linked-list/solution/
 * 题解：https://blog.csdn.net/youngyangyang04/article/details/108586929
 */
public class MyLinkedList {

    private final ListNode dummy;
    private int size = 0;

    public MyLinkedList() {
        dummy = new ListNode(0);
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode curr = dummy;
        for (int i = 0; i < index + 1; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);

    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }

        if (index < 0) {
            index = 0;
        }

        ListNode pre = dummy;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = pre.next;
        pre.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
         size--;
        ListNode pre = dummy;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;

    }


}

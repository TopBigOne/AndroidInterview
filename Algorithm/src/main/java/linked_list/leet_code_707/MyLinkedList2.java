package linked_list.leet_code_707;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/18 19:52
 * @Desc :
 */
public class MyLinkedList2 {

    int size;
    ListNode dummy;

    public MyLinkedList2() {
        size = 0;
        dummy = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        ListNode curr = dummy;
        for (int i = 0; i < index + 1; ++i) {
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
        ++size;
        ListNode pre = dummy;
        for (int i = 0; i < index; ++i) {
            pre = pre.next;
        }

        ListNode toAdd = new ListNode(val);
        toAdd.next = pre.next;
        pre.next = toAdd;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        ListNode pred = dummy;
        for (int i = 0; i < index; ++i) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }


}

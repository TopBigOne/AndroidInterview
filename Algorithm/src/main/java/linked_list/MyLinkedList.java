package linked_list;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/8/29 16:38
 * @Url : https://leetcode-cn.com/leetbook/read/linked-list/jy291/
 * @Level :  easy
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class MyLinkedList {
    private Node node;
    private Node head;
    private Node tail;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (head == null) {
            return -1;
        }
        if (index > size) {
            return -1;
        }
        if (index <= 0) {
            return -1;
        }
        Node temp = head;
        for (int i = 0; i <= index; i++) {
            temp = temp.next;
        }

        return temp.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        // 没有节点
        if (head == null) {
            head = new Node(val);
            node = head;
            tail = head;
            size++;
            return;
        }
        // 已经有了新节点；
        Node temp = new Node(val);
        temp.next = node;
        node.pre = temp;
        head = temp;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        node = new Node(val);
        if (head == null) {
            head = tail = node;
            size++;
            return;
        }

        tail.next = node;
        node.pre = tail;
        tail = node;
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        node = new Node(val);

    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {

    }

    static class Node {
        int val;
        Node pre;
        Node next;

        public Node(int val) {
            this.val = val;
        }

    }
}

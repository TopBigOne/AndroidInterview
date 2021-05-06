package lru.leet_code_146;

import java.util.HashMap;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/6 14:30
 * @Desc :  Lru Cache https://leetcode-cn.com/problems/lru-cache/solution/
 * 字节：38次
 */
public class LRUCache2 {
    private Node head;
    private Node tail;
    private int capacity;
    private HashMap<Integer, Node> map;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        // 存在
        int res = node.value;
        // 1: 移除当前node；
        remove(node);
        // 2: 将当前正在使用的节点，放在头部；
        appendHead(node);
        return res;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        // 1:已经存在，
        if (node != null) {
            node.value = value;
            remove(node);
            appendHead(node);
            return;
        }
        // 2:node 不存在，是一个新节点
        node = new Node(key, value);
        // 2.1:判断缓存大小
        // 没有超过缓存大小，直接放入
        if (map.size() < capacity) {
            appendHead(node);
            map.put(key, node);
            return;
        }
        // 2.2 cache 已满了，移除尾部，再做添加
        map.remove(tail.key);
        remove(tail);

        appendHead(node);
        map.put(key, node);

    }


    private void appendHead(Node newNode) {
        // 第一次添加
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // 头插法
        newNode.next = head;
        head.pre = newNode;
        head = newNode;
    }

    private void remove(Node deletedNode) {
        // 1： 就一个节点
        if (head == tail) {
            head = tail = null;
            return;
        }
        // 2：移除头节点
        if (head == deletedNode) {
            head = head.next;
            // help GC;
            deletedNode.next = null;
            return;
        }
        // 3: 移除尾节点
        if (tail == deletedNode) {
            // 前移一位
            tail = tail.pre;
            // 尾节点的下一个节点为空
            tail.next = null;
            deletedNode.pre = null;
            return;
        }
        // 移除链表中间某个位置的节点
        deletedNode.pre.next = deletedNode.next;
        deletedNode.next.pre = deletedNode.pre;
        // help GC;
        deletedNode.pre = null;
        deletedNode.next = null;

    }

   static class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


}

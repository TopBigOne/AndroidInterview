package lru.leet_code_146;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : dev
 * @version :zxo
 * @Date :  8/21/21 10:54 PM
 * @Desc :
 */
public class LRUCache6 {
    private final int capacity;
    private final Map<Integer, Node> map;
    private DoubleList cache;

    public LRUCache6(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
        } else {
            if (capacity == cache.getSize()) {
                Node last = cache.removeLast();
                map.remove(last.key);
            }
        }

        cache.addFirst(node);
        map.put(key, node);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).val;
        put(key, val);
        return val;

    }


    /**
     * 双端链表；
     * 主要有 Node : head，Node : tail ,int :size ,三个变量；
     */
    static class DoubleList {
        Node head;
        Node tail;
        int size;

        /**
         * 保证头部的数据，永远是最近使用的;
         * 1. 第一个添加，头节点和尾节点都是空的；
         * 2. 在头部添加；
         *
         * @param node
         */
        public void addFirst(Node node) {
            if (head == null) {
                head = tail = node;
                size++;
                return;
            }

            // case 2:
            Node temp = head;
            temp.pre = node;
            node.next = temp;
            head = node;
            size++;
        }

        /**
         * 移除末尾的陈年老数据
         *
         * @return
         */
        public Node removeLast() {
            Node temp = tail;
            remove(tail);
            return temp;
        }

        /**
         * 删除链表中的节点；
         * 1.就一个节点；
         * 2.删除的节点是头节点；
         * 3.删除的节点是尾节点；
         * 4.删除的节点在链表的中间位置；
         *
         * @param node
         */
        private void remove(Node node) {
            // case one:
            if (node == head &&node == tail) {
                head = null;
                tail = null;
                size--;
                return;
            }
            // case two :
            if (node == head) {
                node.next.pre = null;
                head = node.next;
                size--;
                return;
            }
            // case three
            if (node == tail) {
                node.pre.next = null;
                tail = node.pre;
                size--;
                return;
            }
            // case four
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;

        }

        private int getSize() {
            return size;
        }

    }

    /**
     * Node 节点
     */
    static class Node {
        int key;
        int val;
        Node pre;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

}

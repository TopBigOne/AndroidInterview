package lru.leet_code_146;

import java.util.HashMap;

/**
 * @author : dev
 * @version :
 * @Date :  7/1/21 10:24 PM
 * @Desc : https://leetcode-cn.com/problems/lru-cache/submissions/
 * <p>
 * <p>
 * 题解： https://leetcode-cn.com/problems/lru-cache/solution/lru-ce-lue-xiang-jie-he-shi-xian-by-labuladong/
 */
public class LRUCache3 {
    private final HashMap<Integer, Node> map;
    private final DoubleList cache;
    private final int cap;

    public LRUCache3(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        int val = map.get(key).val;
        put(key, val);
        return val;
    }

    public void put(int key, int value) {

        Node x = new Node(key, value);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
        } else {
            if (cap == cache.size()) {
                Node last = cache.removeLast();
                map.remove(last.key);
            }
        }
        cache.addFirst(x);
        map.put(key, x);

    }

    static class Node {
        public int key, val;
        public Node next, prev;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    static class DoubleList {
        private Node head, tail;
        private int size;

        public void addFirst(Node node) {
            if (head == null) {
                head = tail = node;
            } else {
                Node n = head;
                n.prev = node;
                node.next = n;
                head = node;
            }
            size++;
        }

        public void remove(Node node) {
            if (head == node && tail == node) {
                head = null;
                tail = null;
            } else if (tail == node) {
                node.prev.next = null;
                tail = node.prev;
            } else if (head == node) {
                node.next.prev = null;
                head = node.next;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            size--;
        }

        public Node removeLast() {
            Node node = tail;
            remove(tail);
            return node;
        }

        public int size() {
            return size;
        }
    }

}




package lru.leet_code_146;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/27 17:29
 * @Desc :
 */
public class LRUCache10 {

    private final int capacity;
    public Map<Integer, Node> map = new HashMap<>();
    private final DoubleList cache = new DoubleList();

    public LRUCache10(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        int val = node.value;
        put(key, val);
        return val;
    }

    public void put(int key, int val) {
        Node node = new Node(key, val);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
        } else {
            if (cache.getSize() == capacity) {
                Node tail = cache.removeLast();
                map.remove(tail.key);
            }
        }
        cache.addFirst(node);
        map.put(key, node);
    }


    static class DoubleList {
        private int size = 0;
        Node head;
        Node tail;

        public void addFirst(Node node) {
            if (head == null) {
                head = tail = node;
                size++;
                return;
            }
            Node temp = head;
            node.next = head;
            temp.pre = node;
            head = node;
            size++;
        }

        public Node removeLast() {
            Node temp = tail;
            remove(tail);
            return temp;
        }

        private void remove(Node node) {
            // case 1:
            if (node == head && node == tail) {
                head = tail = null;
                size--;
                return;
            }
            // case 2:
            if (node == head) {
                node.next.pre = null;
                head = node.next;
                size--;
                return;
            }
            // case 3:
            if (node == tail) {
                node.pre.next = null;
                tail = node.pre;
                size--;
                return;
            }
            // case 4:  delete the middle  node .
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

        public int getSize() {
            return size;
        }


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

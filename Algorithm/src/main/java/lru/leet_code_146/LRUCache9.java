package lru.leet_code_146;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/27 13:05
 * @Desc :
 */
public class LRUCache9 {

    private Map<Integer, Node> map = new HashMap<>();
    private DoubleList cache = new DoubleList();
    int capacity = 0;

    public LRUCache9(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).val;
        put(key, val);
        return val;
    }

    public void put(int key, int val) {
        Node node = new Node(key, val);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
        } else {
            if (cache.getSize() == capacity) {
                Node temp = cache.removeLast();
                map.remove(temp.key);
            }
        }
        cache.addFirst(node);
        map.put(key, node);
    }

    static class DoubleList {
        int size;
        private Node head;
        private Node tail;

        public void addFirst(Node node) {
            if (head == null) {
                head = tail = node;
                size++;
                return;
            }
            Node temp = head;

            node.next = temp;
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
                head = null;
                tail = null;
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
                // 1-2=3;
                node.pre.next = null;
                tail = node.pre;
                size--;
                return;
            }
            // case 4:
            // 1-2-3-4
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

        private int getSize() {
            return size;
        }
    }

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

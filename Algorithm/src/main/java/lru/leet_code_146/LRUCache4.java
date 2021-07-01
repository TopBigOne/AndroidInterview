package lru.leet_code_146;


import java.security.PublicKey;
import java.util.HashMap;

/**
 * @author : dev
 * @version :
 * @Date :  7/2/21 12:00 AM
 * @Desc :
 */
public class LRUCache4 {
    private final HashMap<Integer, Node> map;
    private final DoubleList cache;
    private final int capacity;

    public LRUCache4(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // 1： 通过 HashMap 快速获取 Node 节点，并拿到值；
        int val = map.get(key).val;
        // 2： 放在首位
        put(key, val);
        return val;
    }

    public void put(int key, int value) {
        Node x = new Node(key, value);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
        } else {
            if (capacity == cache.size()) {
                Node last = cache.removeLast();
                map.remove(last.key);
            }
        }
        cache.addFirst(x);

        map.put(key, x);
    }


    /**
     * 节点
     */
    static class Node {
        public int key, val;
        public Node next, prev;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    static class DoubleList {
        private Node head;
        private Node tail;
        private int size;

        public void addFirst(Node node) {
            // 1:
            if (head == null) {
                head = tail = node;
                size++;
                return;
            }
            // 2:
            Node temp = head;
            temp.prev = node;
            node.next = temp;
            head = node;
            size++;
        }

        public void remove(Node node) {
            // 1: 就一个节点
            if (head == node && node == tail) {
                head = null;
                tail = null;
                size--;
                return;
            }
            // 2: 删除的是尾节点
            if (tail == node) {
                node.prev.next = null;
                tail = node.prev;
                size--;
                return;
            }
            // 3： 删除的是头节点
            if (node == head) {
                node.next.prev = null;
                head = node.next;
                size--;
                return;
            }
            // 4： 删除的是中间的某一个节点
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        private Node removeLast() {
            Node temp = tail;
            remove(tail);
            return temp;
        }

        public int size() {
            return size;
        }

    }


}

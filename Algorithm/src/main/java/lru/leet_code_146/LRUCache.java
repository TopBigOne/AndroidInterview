package lru.leet_code_146;


import java.util.HashMap;

/**
 * @author : dev
 * @version :
 * @Date :  3/28/21 6:20 PM
 * @Desc : Lru Cache https://leetcode-cn.com/problems/lru-cache/solution/
 * 底层用的
 * <p>
 * <p>
 * 视频讲解（https://www.bilibili.com/video/BV13i4y1b7Qy/?spm_id_from=autoNext）
 * 类似题目：LFU
 */
public class LRUCache {
    private int cap;
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>(capacity);

    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }

        int res = node.value;
        // 移除当前 Node 所在的位置，
        remove(node);
        // 将当前的使用的节点，放到头部
        appendHead(node);
        return res;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value);

            // cash 没有满
            if (map.size() < cap) {
                appendHead(node);
                map.put(key, node);
                return;
            }
            // cache 已经满了,移除尾部
            map.remove(tail.key);
            remove(tail);

            appendHead(node);
            map.put(key, node);
            return;

        }

        // node 已经存在
        node.value = value;
        remove(node);
        appendHead(node);
    }

    private void appendHead(Node node) {
        // 第一次添加的时候
        if (head == null) {
            head = tail = node;
            return;
        }
        node.next = head;
        head.pre = node;
        // 注意哦，这行代码一定要有；
        head = node;

    }

    /**
     * 删除指定节点
     *
     * @param node
     */
    private void remove(Node node) {
        if (head == tail) {
            head = tail = null;
            return;
        }

        if (head == node) {
            head = head.next;
            node.next = null;
            return;
        }

        if (tail == node) {
            tail = tail.pre;
            tail.next = null;
            node.pre = null;
            return;
        }

        // 删除的是中间节点
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;
    }

    static class Node {
        Node pre;
        Node next;

        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

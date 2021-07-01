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
    private final int cap;
    private Node head;
    private Node tail;
    private final HashMap<Integer, Node> map;

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

            // cache 没有满
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

    /**
     * 头插法
     *
     * @param newNode 新插入的节点；
     */
    private void appendHead(Node newNode) {
        // 第一次添加的时候
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // 头插法
        newNode.next = head;
        head.pre = newNode;
        head = newNode;
    }

    /**
     * 删除指定节点
     *
     * @param deletedNode
     */
    private void remove(Node deletedNode) {
        if (head == tail) {
            head = tail = null;
            return;
        }

        if (head == deletedNode) {
            head = head.next;
            deletedNode.next = null;
            return;
        }

        if (tail == deletedNode) {
            tail = tail.pre;
            tail.next = null;
            deletedNode.pre = null;
            return;
        }

        // 删除的是中间节点
        deletedNode.pre.next = deletedNode.next;
        deletedNode.next.pre = deletedNode.pre;
        // help GC;
        deletedNode.pre = null;
        deletedNode.next = null;
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

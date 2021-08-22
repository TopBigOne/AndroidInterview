package lru.leet_code_146;

import java.util.HashMap;

/**
 * @author : dev
 * @version :
 * @Date :  2021/7/2 10:47
 * @Desc :
 */
public class LRUCache5 {
    private HashMap<Integer,Node> map;
    private DoubleList cache;
    private int cap;

    public LRUCache5(int cap){
        this.cap = cap;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public void put(int key,int value){
        Node node = new Node(key,value);
        if(map.containsKey(key)){
           map.remove(key);
        }else {
            if(cap == cache.size()){
                Node last = cache.removeLast();
                map.remove(last.key);
            }
        }
        cache.addFirst(node);
        map.put(key,node);
    }
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }

        int  val = map.get(key).val;

        put(key,val);
        return val;

    }



    static class Node {
        Node pre;
        Node next;
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    static class DoubleList {
        Node head;
        Node tail;
        int size;

        public void addFirst(Node node) {
            if (head == null) {
                head = tail = node;
                size++;
                return;
            }
            Node temp = head;
            temp.pre = node;
            node.next = temp;
            head = node;
            size++;
        }

        public void remove(Node node) {
            // 1: 恰巧头尾相等
            if (node==head&&node == tail) {
                head = tail = null;
                size--;
                return;
            }
            // 2: 删除的是head
            if (head==node) {
                node.next.pre = null;
                head = node.next;
                size--;
                return;
            }

            // 3: 删除的tail
            if(node ==tail){
                node.pre.next = null;
                tail = node.pre;
                size--;
                return;
            }
            // 4: 删除的是中间的节点
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

        public Node removeLast() {
            Node temp = tail;
            remove(tail);
            return temp;
        }

        public int size() {
            return size;
        }
    }

}

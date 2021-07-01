package lru.leet_code_146;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/6 16:39
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        LRUCache2 lruCache2 = new LRUCache2(2);
        lruCache2.put(1, 1);
        lruCache2.put(2, 2);
        lruCache2.get(1);
        lruCache2.put(3, 3);
        lruCache2.get(2);

        lruCache2.put(4, 4);
        lruCache2.get(1);
        lruCache2.get(3);
        lruCache2.get(4);


    }


    private static void test2(){
        LRUCache lruCache = new LRUCache(100);
        lruCache.put(1,2);

    }
}

package lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRUCache
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super((int) Math.ceil(capacity / 0.75) + 1, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (containsKey(key)) {
            return super.get(key);
        } else {
            return -1;
        }
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(6);
        lruCache.put(1, 1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
}

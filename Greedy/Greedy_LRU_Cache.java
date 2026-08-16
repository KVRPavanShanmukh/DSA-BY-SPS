import java.util.*;

class LRUCache {
    class Node {
        int key;
        int val;
        Node next;
        Node prev;
        Node(int _key, int _val) {
            key = _key;
            val = _val;
        }
    }
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    // Capacity of cache
    int cap;
    
    HashMap<Integer, Node> hm = new HashMap<>();
    // Constructor to initialize LRU cache
    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    void addNode(Node newNode) {
        Node temp = head.next;
        newNode.next = temp;
        newNode.prev = head;
        head.next = newNode;
        temp.prev = newNode;
    }

    void deleteNode(Node delNode) {
        Node delPrev = delNode.prev;
        Node delNext = delNode.next;
        delPrev.next = delNext;
        delNext.prev = delPrev;
    }

    public int get(int key_) {
        if (hm.containsKey(key_)) {
            Node resNode = hm.get(key_);
            int res = resNode.val;  // Remove old mapping
            hm.remove(key_);    // Move accessed node to front
            deleteNode(resNode);
            addNode(resNode);   // Update map
            hm.put(key_, head.next);
            return res;
        }
        return -1;
    }

    public void put(int key_, int value) {
        if (hm.containsKey(key_)) {
            Node existingNode = hm.get(key_);
            hm.remove(key_);
            deleteNode(existingNode);
        }
        // If capacity reached
        if (hm.size() == cap) {
            hm.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        // Insert new node at front
        addNode(new Node(key_, value));
        hm.put(key_, head.next);
    }
}

public class Greedy_LRU_Cache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);

        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);

        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
package oj.others;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private int count;
    private Map<Integer, DLinkedNode> map;
    private DLinkedNode head, tail;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.count = 0;
        map = new HashMap<Integer, DLinkedNode>();
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        DLinkedNode n = map.get(key);
        if(n == null){
            return -1;
        }
        update(n);
        return n.value;
    }

    public void put(int key, int val){
        DLinkedNode n = map.get(key);
        if(null == n){
            n = new DLinkedNode(key, val);
            map.put(key, n);
            ++count;
        } else{
            n.value = val;
            update(n);
        }

        if(count > capacity){
            DLinkedNode toDel = tail.prev;
            remove(toDel);
            map.remove(toDel.key);
            --count;
        }
    }

    private void update(DLinkedNode node){
        remove(node);
        addToFirst(node);
    }

    private void addToFirst(DLinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
    }

    private void remove(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }
}

class DLinkedNode{
    int key;
    int value;
    DLinkedNode prev;
    DLinkedNode next;

    DLinkedNode(int k, int v){
        this.key = k;
        this.value = v;
    }
    DLinkedNode(){
        this(0, 0);
    }
}

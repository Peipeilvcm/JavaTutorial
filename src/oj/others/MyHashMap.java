package oj.others;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap<K, V> {
    private static float DEFAULT_LOAD_FACTOR = 0.75f;
    private static int defaultLength = 16;
    private MyEntry<K, V>[] table = null;
    private int size = 0;

    public MyHashMap(int length, float loader){
        this.defaultLength = length;
        this.DEFAULT_LOAD_FACTOR = loader;
        table = new MyEntry[defaultLength];
    }
    public MyHashMap(){
        this(defaultLength, DEFAULT_LOAD_FACTOR);
    }

    public V put(K key, V value){
        // 判断是否扩容
        if(size >= defaultLength * DEFAULT_LOAD_FACTOR){
            resize();
        }

        // 散列函数获取地址
        int index = getIndex(key);
        MyEntry<K, V> entry = table[index];

        if(entry == null){
            table[index] = new MyEntry<K, V>(key, value, null);
            size++;
        }else{
            table[index] = new MyEntry<K, V>(key, value, entry);
        }
        return table[index].getValue();
    }

    private void resize(){
        // 2倍扩容
        MyEntry<K, V>[] newTable = new MyEntry[2*defaultLength];
        // 原数据再散列，存在新容器
        againHash(newTable);
    }

    private void againHash(MyEntry<K,V>[] newTable){
        List<MyEntry<K,V>> list = new ArrayList<MyEntry<K,V>>();
        for(int i=0;i<table.length;i++) {
            if(table[i]==null) {
                continue;
            }else{
                findEntry(table[i], list);
            }
        }

        if(list.size() > 0){
            size = 0;
            defaultLength *= 2;
            table = newTable;
            for(MyEntry<K,V> entry : list){
                if(entry.next != null){
                    entry.next = null;
                }
                put(entry.getKey(), entry.getValue());
            }
        }
    }
    // 取出原数据
    private void findEntry(MyEntry<K,V> entry, List<MyEntry<K,V>> list){
        if(entry !=null && entry.next !=null) {
            list.add(entry);
            findEntry(entry.next,list);
        } else{
            list.add(entry);
        }
    }

    private int getIndex(K key){
        int m = defaultLength;
        int index = key.hashCode() % m;
        return index >= 0 ? index : -index;
    }

    public V get(K key){
        int index = getIndex(key);
        if(table[index] == null){
            return null;
        }
        return getValueByKey(key, table[index]);
    }
    // 通过key取出数据    如果存在冲突   则递归查找该链表
    private V getValueByKey(K k, MyEntry<K,V> entry){
        if(k == null){
            return null;
        }
        while (entry != null){
            if(k==entry.getKey() || k.equals(entry.getKey())){
                return entry.getValue();
            }
            entry = entry.next;
        }
        return null;
    }

    public class MyEntry<K, V>{
        K k;
        V v;
        MyEntry<K, V> next;

        public MyEntry(K k, V v, MyEntry next){
            this.k=k;
            this.v=v;
            this.next=next;
        }

        public K getKey(){
            return k;
        }
        public V getValue() {
            return v;
        }
    }
}

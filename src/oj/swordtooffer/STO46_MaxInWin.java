package oj.swordtooffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class STO46_MaxInWin {
    class Pair{
        Integer key;
        Integer value;
        Pair(Integer key, Integer value){
            this.key = key;
            this.value = value;
        }
        public Integer getKey(){
            return key;
        }
        public Integer getValue(){
            return value;
        }
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size){
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(num == null || num.length < size || size <= 0){
            return res;
        }
        Queue<Pair> maxHeap = new PriorityQueue<Pair>(1,
                new Comparator<Pair>() {
                    @Override
                    public int compare(Pair o1, Pair o2) {
                        return o2.getKey() - o1.getKey();
                    }
                });
        int i = 0;

        for(; i < size; ++i){
            maxHeap.offer(new Pair(num[i], i));
        }
        res.add(maxHeap.peek().getKey());
        for(; i < num.length; ++i){
            maxHeap.offer(new Pair(num[i],i));
            while(maxHeap.peek().getValue() < i - size + 1){
                maxHeap.poll();
            }
            res.add(maxHeap.peek().getKey());
        }
        return res;
    }
}

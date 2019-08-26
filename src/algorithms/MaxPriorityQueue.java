package algorithms;

public class MaxPriorityQueue<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0; // 存在pq[1..N]中

    public MaxPriorityQueue(int maxN){
        pq = (Key[]) new Comparable[maxN+1];
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    public void insert(Key v){
        pq[++N] = v;

    }
    public Key delMax(){
        Key max = pq[1];
        exch(1, N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }

    // 比较第i个和第j个
    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    // 交换第i和第j个
    private void exch(int i, int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    // 将第k个值上浮
    private void swim(int k){
        while (k > 1 && less(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    // 将第k和下沉
    private void sink(int k){
        while (2 * k <= N){
            int j = 2 * k;
            if(j < N && less(j, j+1)){
                j++; // 子节点选值大的交换
            }
            if(!less(k, j)){
                // 终止条件，大于子节点较大值
                break;
            }
            exch(k, j);
            k = j;
        }
    }
}

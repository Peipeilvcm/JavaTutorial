package algorithms;

public class UF {
    private int[] id;  // 父连接数组
    private int[] sz;  // 各个根节点所对应的分量大小
    private int count; // 分量数量

    // 初始化，0.. N-1
    UF(int N){
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; ++i){
            id[i] = i;
            sz[i] = 1;
        }
    }

    void union(int p, int q){
        int i = find(p);
        int j = find(q);
        if(i == j){
            return;
        }

        // 小树连大树
        if(sz[i] < sz[j]){
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }

        count--;
    }

    int find(int p){
        while (p != id[p]){
            p = id[p];
        }
        return p;
    }

    boolean connected(int p, int q){
        return find(p) == find(q);
    }

    // 连通分量数量
    int count(){
        return count;
    }
}

package oj.leetcode.DP;

public class AritSlices_413 {
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        int n = A.length;
        if(n < 3){
            return 0;
        }

        int interval = A[1] - A[0];
        int cnt = 1;

        for(int i = 2; i < n; ++i){
            if(A[i] - A[i-1] == interval){
                cnt++;
            }else{
                interval = A[i] - A[i-1];
                res += (cnt*(cnt - 1))/2;
                cnt = 1;
            }
        }
        res += (cnt*(cnt - 1))/2;
        return res;
    }
}

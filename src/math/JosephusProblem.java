package math;

public class JosephusProblem {
    public static int slove1(int n, int m) {
        int result = 1;
        int delta;
        for (int t = 2; t < n; ++t) {

            if (result + m < t) {
                delta = (t - result) / m;
                if (delta > n - t) {
                    delta = n - t;
                }
                t += delta;
                result += m * delta;
            }
            result = (result + m - 1) % t + 1;
        }
        return result;
    }
}
//    public static int solve2(int n, int m){
//        int res = 0;
//        for(int i = 2; i <= n; ++i){
//            res = (res + m) % i;
//        }
//        return res + 1;
//    }
//

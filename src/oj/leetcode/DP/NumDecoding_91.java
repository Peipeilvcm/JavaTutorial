package oj.leetcode.DP;

/*
* A->1..Z->26
* 12可以被编码为AB或L,给出数字串,计算编码种类*/
public class NumDecoding_91 {
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 0){
            return 0;
        }

        int[] dp = new int[n+1];
        dp[n] = 1;
        // 最后一位字符开始
        dp[n-1] = s.charAt(n-1) != '0' ? 1 : 0;
        for(int i = n-2; i >= 0; --i){
            if(s.charAt(i) == '0'){
                dp[i] = 0;
            }else{
                if(Integer.parseInt(s.substring(i, i + 2)) <= 26){
                    dp[i] = dp[i+1] + dp[i+2];
                }else{
                    dp[i] = dp[i+1];
                }
            }
        }
        return dp[0];
    }
}

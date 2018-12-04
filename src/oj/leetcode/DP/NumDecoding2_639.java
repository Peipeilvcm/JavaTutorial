package oj.leetcode.DP;

/*
 * A->1..Z->26
 * 12可以被编码为AB或L,给出数字串,计算编码种类
 * 现在输入数字串可能带有*号能代表1-9的任意数字
 * mod 1000000007*/
public class NumDecoding2_639 {
    public int numDecodings(String s) {
        int MOD = 1000000007;
        int n = s.length();
        if(n == 0){
            return 0;
        }

        long[] dp = new long[n+1];
        dp[0] = 1;

        // 最后一位字符开始
        if(s.charAt(0) == '*'){
            dp[1] = 9;
        }else if(s.charAt(0) == '0'){
            dp[1] = 0;
        }else{
            dp[1] = 1;
        }

        for(int i = 1; i < n; ++i){
            char cur_c = s.charAt(i);
            char pre_c = s.charAt(i-1);
            if(cur_c == '*'){
                dp[i+1] = (9*dp[i]) % MOD;
                if(pre_c == '1'){
                    dp[i+1] = (dp[i+1] + 9*dp[i-1])%MOD;
                }else if(pre_c == '2'){
                    dp[i+1] = (dp[i+1] + 6*dp[i-1])%MOD;
                }else if(pre_c == '*'){
                    dp[i+1] = (dp[i+1] + 15*dp[i-1])%MOD;
                }
            }else{
                dp[i+1] = cur_c == '0' ? 0 : dp[i];
                if(pre_c == '1'){
                    dp[i+1] = (dp[i+1] + dp[i-1])%MOD;
                }else if(pre_c == '2' && cur_c <= '6'){
                    dp[i+1] = (dp[i+1] + dp[i-1])%MOD;
                }else if(pre_c == '*'){
                    dp[i+1] = (dp[i+1] + (cur_c <= '6' ? 2 : 1)*dp[i-1])%MOD;
                }

            }
        }
        return (int)dp[n];
    }

}

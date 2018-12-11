package oj.others;

public class Knapsack {
    // 时间复杂度n*C, 空间C, 如有输入w和v两个数组, 可用两个变量代替
    int knapsack01_1(int[] w, int[] v, int C) {
        int n = w.length;
        if(n == 0){
            return 0;
        }
        int[] memo = new int[C+1];
        for(int i = 0; i < n; ++i){
            for(int j = C; j >= w[i]; --j){
                memo[j] = Math.max(memo[j], v[i] + memo[j - w[i]]);
            }
        }
        return memo[C];
    }

    //变种2, 改变dp对象,当n和C过大总价值较小时,dp[i][j]表示前i个物品价值为j的最小重量
    int knapsack01_2(int[] w, int[] v, int C){
        final int MAX_INT = 99999;
        int n = w.length;
        if(n == 0){
            return 0;
        }
        int sum = 0;
        for(int i = 0; i < n; ++i){
            sum += v[i];
        }
        int[] memo = new int[sum+1];
        for(int i = 0; i <= sum; ++i){
            memo[i] = MAX_INT;
        }

        for(int i = 0; i < n; ++i){
            for(int j = sum; j >= v[i]; --j){
                memo[j] = Math.min(memo[j], w[i] + memo[j - v[i]]);
            }
        }
        for(int j = sum; j >= 0; --j){
            if(memo[j] <= C){
                return j;
            }
        }
        return 0;
    }

    // 变种3, 完全背包
    int knapsack01_3(int[] w, int[] v, int C){
        int n = w.length;
        if(n == 0){
            return 0;
        }
        int[] memo = new int[C+1];
        for(int i = 0; i < n; ++i){
            for(int j = w[i]; j <= C; ++j){
                // 完全背包，从前往后遍历
                memo[j] = Math.max(memo[j], v[i] + memo[j - w[i]]);
            }
        }
        return memo[C];
    }

    // 变种4, 01背包, 刚好装满
    int knapsack01_4(int[] w, int[] v, int C){
        int n = w.length;
        if(n == 0){
            return 0;
        }
        int[] memo = new int[C+1];
        for(int i = 0; i <= C; ++i){
            memo[i] = -1;
        }
        memo[0] = 0;
        for(int i = 0; i < n; ++i){
            for(int j = C; j >= w[i]; --j){
                if(memo[j - w[i]] != -1){
                    memo[j] = Math.max(memo[j], memo[j - w[i]]+v[i]);
                }
            }
        }
        return memo[C];
    }

    //变种5, 完全背包+刚好装满,最大价值
    int knapsack01_5(int[] w, int[] v, int C){
        int n = w.length;
        if(n == 0){
            return 0;
        }
        int[] memo = new int[C+1];
        for(int i = 0; i <= C; ++i){
            memo[i] = -1;
        }
        memo[0] = 0;

        for(int i=0; i<n; ++i){
            for(int j = w[i]; j <= C; ++j){	//完全背包,从前往后循环
                if(memo[j-w[i]] != -1){
                    memo[j] = Math.max(memo[j], v[i]+memo[j-w[i]]);
                }
            }
        }
        return memo[C];
    }

    //变种6, 完全背包+刚好装满,方案数量
    int knapsack01_6(int[] w, int C){
        int n = w.length;
        if(n == 0){
            return 0;
        }
        int[] memo = new int[C+1];
        memo[0] = 0;
        for(int i=0; i < n; ++i){
            for(int j = w[i]; j <= C; ++j){	//完全背包,从前往后循环
                memo[j] += memo[j - w[i]];
            }
        }
        return memo[C];
    }

    // 变种7, 01背包+刚好装满, 方案数量, 需要手动输入w时可以用变量代替数组
    int knapsack01_7(int[] w, int C){
        int n = w.length;
        if(n == 0){
            return 0;
        }
        int[] memo = new int[C+1];
        memo[0] = 1;

        for(int i=0; i < n; ++i){
            for(int j = C; j >= w[i]; ++j){	//01背包,从后往前循环
                memo[j] += memo[j - w[i]];
            }
        }

        return memo[C];
    }

}

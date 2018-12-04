package oj.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    // 字符串无重复字符
    public List<String> StringPermutation(String str){
        List<String> res = new ArrayList<String>();
        if(str == null || str.length() == 0){
            return res;
        }

        char[] c = str.toCharArray();
        Arrays.sort(c);
        boolean[] used = new boolean[c.length];
        helper(res, c, used, "");
        return res;
    }

    private void helper(List<String> res, final char[] c, boolean[] used, String s){
        if(s.length() == c.length){
            res.add(s);
            return;
        }
        for(int i = 0; i < c.length; ++i){
            if(used[i]){
                continue;
            }
            if(i > 0 && c[i-1] == c[i] && !used[i-1]){
                // 处理重复字符
                continue;
            }
            used[i] = true;
            s += c[i];
            helper(res, c, used, s);
            used[i] = false;
            s = s.substring(0, s.length()-1);
        }
    }

    // 字典序方法，下一个排列
    void nextIntPermutation(int[] nums){
        System.out.printf("nums : %s",Arrays.toString(nums));
        int n = nums.length;
        if(n < 2){
            return;
        }
        int k = -1;
        for(int i = n-2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                k = i;
                break;
            }
        }
        if(k == -1){
            // 是最后一个排序，回到最初顺序
            Arrays.sort(nums);
        }else{
            for(int i = n-1; i > k; --i){
                if(nums[i] > nums[k]){
                    int tmp = nums[i];
                    nums[i] = nums[k];
                    nums[k] = tmp;
                    reverse(nums, k+1, n-1);
                    return;
                }
            }
        }

        System.out.printf("-> %s",Arrays.toString(nums));
    }

    private void reverse(int[] nums, int l, int r){
        int tmp = 0;
        while(l < r){
            tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
}

package oj.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    // 没有重复
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack_1(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }
    private void backtrack_1(List<List<Integer>> res, List<Integer> tempList, int [] nums, boolean[] used){
        if(tempList.size() == nums.length){
            res.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(used[i]) continue;
                tempList.add(nums[i]);
                used[i] = true;
                backtrack_1(res, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    // 有重复
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack_2(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }
    private void backtrack_2(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i - 1])) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack_2(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}

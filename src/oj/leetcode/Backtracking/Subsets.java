package oj.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    // 不包含重复数据
    public List<List<Integer>> subsets_1(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack_1(nums, res, new ArrayList<>(), 0);
        return res;
    }
    // 不包含重复数据
    private void backtrack_1(int[] nums, List<List<Integer>> res, List<Integer> temp, int start) {
        res.add(new ArrayList<>(temp));
        for(int i = start; i < nums.length; ++i){
            temp.add(nums[i]);
            backtrack_1(nums, res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup_2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack_2(nums, res, new ArrayList<>(), 0);
        return res;
    }
    private void backtrack_2(int[] nums, List<List<Integer>> res, List<Integer> temp, int start) {
        res.add(new ArrayList<>(temp));
        for(int i = start; i < nums.length; ++i){
            if (i > start && nums[i] == nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            backtrack_1(nums, res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

}

package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null) {
            if(sum == root.val){
                return true;
            } else {
                return false;
            }
        }

        return hasPathSum(root.right, sum - root.val) || hasPathSum(root.left, sum - root.val);
    }

    // 根到叶子---返回路径
    public List<List<Integer>> pathSum(TreeNode root, int sum){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<Integer>();
        backtrack(res, temp, root, sum);
        return res;
    }
    void backtrack(List<List<Integer>> res, List<Integer> temp, TreeNode now, int remain){
        if(now == null){
            return;
        }
        temp.add(now.val);
        if(now.left == null && now.right == null){
            if(remain == now.val){
                res.add(new ArrayList<>(temp));
            }
            temp.remove(temp.size() - 1);
            return;
        }

        backtrack(res, temp, now.left, remain - now.val);
        backtrack(res, temp, now.right, remain - now.val);

        temp.remove(temp.size() - 1);
    }

    // 路径上任意路径都行，不必根到叶子，返回路径个数
    public int pathSum3(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        int m = pathSum3FromRoot(root, sum);
        int mL = pathSum3(root.left, sum);
        int mR = pathSum3(root.right, sum);
        return m + mL + mR;
    }
    private int pathSum3FromRoot(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        int m = root.val == sum ? 1 : 0;
        return m + pathSum3FromRoot(root.left, sum-root.val) + pathSum3FromRoot(root.right, sum - root.val);
    }
}

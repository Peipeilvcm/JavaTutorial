package oj.swordtooffer;

import tree.TreeNode;

/**
 * Created by Administrator on 2018/11/23.
 */
public class STO3_SubTree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null){
            return false;
        }

        if(isSameTree(root1,root2)){
            return true;
        }

        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }
    public boolean isSameTree(TreeNode root1, TreeNode root2){
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }

        if(root1.val == root2.val){
            return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
        }else{
            return false;
        }
    }
}

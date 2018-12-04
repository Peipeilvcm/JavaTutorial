package oj.swordtooffer;

import tree.TreeNode;

import java.util.Stack;

public class STO10_ConvertToDList {
    // 递归方法
    public TreeNode convert(TreeNode root){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            return root;
        }
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = convert(root.left);
        TreeNode p = left;
        // 2.定位至左子树双链表最后一个节点
        while (p != null && p.right != null){
            p = p.right;
        }
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left != null){
            p.right = root;
            root.left = p;
        }
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = convert(root.right);
        if(right != null){
            right.left = root;
            root.right = right;
        }

        return left != null ? left : root;
    }

    // 非递归
    public TreeNode convert2(TreeNode root){
        if(root == null){
            return root;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode pre = null;
        boolean isFirst = true;
        while(p != null && !stack.empty()){
            while(p != null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if(isFirst){
                root = p;
                pre = p;
                isFirst = false;
            }else{
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }
        return root;
    }
}

package tree;

import java.util.Stack;

public class VisitOrder {
    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }

        TreeNode p = root;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(p);

        while (!stk.empty()){
            p = stk.pop();

            visit(p);

            if(p.right != null){
                stk.push(p.right);
            }
            if(p.left != null){
                stk.push(p.left);
            }
        }
    }

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }

        TreeNode p = root;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(p);

        while (!stk.empty()){
            while (p != null && p.left != null){
                p = p.left;
                stk.push(p);
            }

            p = stk.pop();
            visit(p);

            if (p.right != null){
                p = p.right;
                stk.push(p);
            }else{
                p = null;
            }
        }
    }

    public void postOrder(TreeNode root){
        if(root == null){
            return;
        }

        TreeNode p = root;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(p);
        stk.push(p);

        while (!stk.empty()){
            p = stk.pop();
            if(!stk.empty() && p == stk.peek()){
                if(p.right != null){
                    stk.push(p.right);
                    stk.push(p.right);
                }
                if(p.left != null){
                    stk.push(p.left);
                    stk.push(p.left);
                }
            }else{
                visit(p);
            }
        }
    }

    private void visit(TreeNode p){
        System.out.println(p.val);
    }
}

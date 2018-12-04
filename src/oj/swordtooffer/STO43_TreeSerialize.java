package oj.swordtooffer;

import tree.TreeNode;

public class STO43_TreeSerialize {
    String Serialize(TreeNode root){
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Serialize(root, sb);
        return sb.toString();
    }
    void Serialize(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("#");
            return;
        }
        sb.append(root.val + ",");
        Serialize(root.left, sb);
        Serialize(root.right, sb);
    }

    TreeNode Deserialize(String str){
        if(str == null || str.length() == 0){
            return null;
        }
        String[] strs = str.split(",");
        return Deserialize(strs);
    }

    int index = -1;
    TreeNode Deserialize(String[] strs){
        index++;
        TreeNode leaf = null;
        if(!"#".equals(strs[index])){
            leaf = new TreeNode(Integer.valueOf(strs[index]));
            leaf.left = Deserialize(strs);
            leaf.left = Deserialize(strs);
        }
        return leaf;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /*
	由于二叉树对称，要从左右子树中判断是否是镜像，因此我们要写一个树的镜像方法（带有两个参数）
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        //空树，对称
        if(root == null)
            return true;
        else
            return isMirror(root.left,root.right);
    }
    public boolean isMirror(TreeNode t1,TreeNode t2) {
        //空树，对称
        if(t1==null && t2==null)
            return true;
        //如果有一个为空，则返回false
        else if(t1== null || t2 == null)
            return false;
        else if(t1.val != t2.val)
            return false;
        else    
            return isMirror(t1.left,t2.right)&&isMirror(t1.right,t2.left);
    }
}
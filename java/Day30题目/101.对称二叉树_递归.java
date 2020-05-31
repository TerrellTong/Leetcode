/*
	算法思想：
		递归，二刷，还是没有思路，被原来做的困扰了

	
	
*/
 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        else
            return isMirror(root.left,root.right);
    }

    public boolean isMirror(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null)
            return true;
        else if(t1 == null || t2 ==null)
            return false;
        else if(t1.val != t2.val)
            return false;
        else
            return isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
    }
}










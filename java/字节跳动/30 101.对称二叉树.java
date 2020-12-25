/*
	算法思想：
		简单的都不会！！！！，之前还做过，这个题目，不能从根结点考虑，我们要从根结点的下一级节点考虑！！！！，如果从根结点考虑，会做不出来！！
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
        else if(t1 == null || t2 == null)
            return false;
        else if(t1.val != t2.val)
            return false;
        else
            return isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
    }
}
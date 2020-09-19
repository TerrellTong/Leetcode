/*
	算法思想：
		先序遍历的思想
		
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
    int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        inorder(root);
        return res;
    }

    public void inorder(TreeNode root){
        if(root == null)
            return;
        if(root.left != null && root.left.left == null && root.left.right == null)
            res += root.left.val;
        
        inorder(root.left);
        inorder(root.right);
    }
}
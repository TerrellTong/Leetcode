/*
	算法思想：
		先序遍历，递归，二刷的，成功做了出来！！
	
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
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int left_length = maxDepth(root.left);
        int right_length = maxDepth(root.right);
        return Math.max(left_length,right_length)+1;
    }
}
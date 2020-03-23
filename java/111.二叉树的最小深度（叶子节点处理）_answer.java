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
	算法思想：
	递归，找到叶子节点则返回1，非叶子节点则返回0（根节点也属于递归节点的判断条件）

 */
class Solution {
	public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
		//如果此节点是叶子节点则返回1 
        if(root.right == null && root.left == null)
            return 1;
        int min_depth = Integer.MAX_VALUE;
		//如果左/右子树不为空就继续递归
		if (root.left != null) {
		  min_depth = Math.min(minDepth(root.left), min_depth);
		}
		if (root.right != null) {
		  min_depth = Math.min(minDepth(root.right), min_depth);
		}

		return min_depth + 1;
    }
   
}

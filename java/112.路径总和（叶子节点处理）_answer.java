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
	递归，找到叶子节点则 sum与0进行判断

 */
class Solution {
	    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        sum = sum - root.val;
		//叶子结点的处理
        if((root.left == null) && (root.right == null))
            return (sum == 0);

        return hasPathSum(root.left,sum)||hasPathSum(root.right,sum);
    }
   
}

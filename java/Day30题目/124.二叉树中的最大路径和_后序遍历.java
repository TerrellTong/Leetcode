/*
	算法思想：
		后序遍历
	
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
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        //通过后序遍历的方式，先计算出左右子树的最大路径和，然后再计算当前树的最大路径和
        maxSum(root);
        return max;
    }

    private int maxSum(TreeNode root){
        //通过后序遍历的方式，先计算出左右子树的最大路径和，然后再计算当前树的最大路径和
        if(root == null)
            return 0;
        int leftMax = Math.max(maxSum(root.left),0);
        int rightMax = Math.max(maxSum(root.right),0);
        max = Math.max(max,leftMax+rightMax+root.val);
        //找到某个结点的最大代价（通过与leftMax，rightMax比较得到的）
        return root.val+Math.max(leftMax,rightMax);
    }
}





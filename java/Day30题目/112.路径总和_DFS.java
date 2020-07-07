/*
	算法思想：
		深度优先遍历（先序遍历）
		
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
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root,sum,0);
    }

    public boolean dfs(TreeNode root,int num,int res){
        if(root == null)
            return false;
        res += root.val;
        if(res == num && root.left==null && root.right == null)
            return true;   
        boolean left_flag = dfs(root.left,num,res);
        boolean right_flag = dfs(root.right,num,res);
        return left_flag || right_flag;
    }

}  






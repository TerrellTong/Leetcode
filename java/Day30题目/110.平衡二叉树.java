/*
	算法思想：
		树的递归，二刷，知道思路，但是必须要在min>1返回！！我自己写的是<1 ,返回false
		
		

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
    //如果将根结点进行递归？

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int len_right = cal_height(root.right);
        int len_left = cal_height(root.left);
        int min = len_left - len_right;
        //必须要在差值大于1，就返回false,不然就会在两个对称的单子树中出现问题！
        if(Math.abs(min) > 1)
            return false;
        return isBalanced(root.left)&&isBalanced(root.right);
    }

    //计算树的高度
    public int cal_height(TreeNode root){
        if(root == null)
            return 0;
        int left_height = cal_height(root.left);
        int right_height = cal_height(root.right);
        return left_height>right_height ? left_height+1 : right_height+1;
    }
}
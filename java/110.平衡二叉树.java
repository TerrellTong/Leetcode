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
	以求二叉树的最高高度为例子，以此为基础再进行平衡性判断

 */
class Solution {
	public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int left_height =Height(root.left);
        int right_height =Height(root.right);
		//如果左右子树高度之差的绝对值大于1，就直接返回false
        if(Math.abs(left_height-right_height) > 1)
            return false;
		//如果左右子树高度之差的绝对值小于1，还要判断它的左右子树是否是平衡的！
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    public int Height(TreeNode t){
        if(t == null){
            return 0;
        }
        int left_height = Height(t.left);
        int right_height = Height(t.right);
        return left_height>right_height ? left_height+1 : right_height+1;
    }
}

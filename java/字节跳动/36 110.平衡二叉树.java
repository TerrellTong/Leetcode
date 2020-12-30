/*
	算法思想：
		递归，之前做过，不会！！！！
		我自己做的时候，只要是满足left- right <=1 就返回true，这样就没有递归作用了！！
		我没有考虑什么时候继续递归下去？？？？？？，当为true则继续递归！！！ 
*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
            if(root == null || (root.left == null && root.right == null))
                return true;
            int left = hight(root.left,1);
            int right = hight(root.right,1);
            return (Math.abs(left - right) <= 1)? isBalanced(root.left)&&isBalanced(root.right) : false;
    }


    //求高度
    public int hight(TreeNode root,int height){
        if(root == null)
            return height+1;
        int left = hight(root.left,height+1);
        int right = hight(root.right,height+1);
        return Math.max(left,right);
    }
}
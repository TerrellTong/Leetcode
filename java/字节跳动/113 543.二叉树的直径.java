/*
	算法思想：
		怎么说呢，直接想的是左高度+右高度！
		但是我们还要判断子树的情况，因此，我们要采用一个全局变量存储！！！
		直径就是左子树的高度+右子树的高度！！！
		之前二刷过，还是一样的问题！！
		
		高度又不会求了 ！！
		
题解：https://leetcode-cn.com/problems/diameter-of-binary-tree/solution/hot-100-9er-cha-shu-de-zhi-jing-python3-di-gui-ye-/

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
    int sum = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)    
            return 0;
        height(root);
        return sum;
    }
	
	//求高度！！！，是将left，right中较大的作为高度！！
    public int height(TreeNode root){
        if(root == null)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        sum = Math.max(left+right,sum);
        return Math.max(left,right)+1;
    }
}
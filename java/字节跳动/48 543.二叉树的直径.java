/*
	算法思想：
		要比较每个字根节点的直径！
		之前做过，二刷成功！！
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
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return res;
    }

    public int height(TreeNode root){
        if(root == null)
            return 0;
        
        int left = height(root.left);
        int right = height(root.right);
        res = Math.max(left+right,res);
        return Math.max(left,right)+1;
    }
}
/*
	算法思想：
		简单的递归思想，采用的先序遍历的思想
		
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
    public TreeNode invertTree(TreeNode root) {
        inorder(root);
        return root;
    }

    public void inorder(TreeNode root){
        if(root == null)
            return;
        // swap(root.left,root.right);
        swap(root);
        inorder(root.left);
        inorder(root.right);
    }

    public void swap(TreeNode root){
        if(root.left == null){
            root.left = root.right;
            root.right = null;
        }else if(root.right == null){
            root.right = root.left;
            root.left = null;
        }else{
            TreeNode tmp = null;
            tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }
    }
}
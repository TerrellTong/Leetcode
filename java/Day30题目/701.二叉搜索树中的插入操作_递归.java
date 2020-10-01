/*
	算法思想：
		递归，我觉得我自己写的有点复杂了！
		利用二叉搜索树的特性！！！小于根的在根左边，大于根的在根右边！！
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
    boolean flag = false;
    int count = 1;
    public TreeNode insertIntoBST(TreeNode root, int val) {
        

        //判断根结点为空时，再使用
        if(count == 1 && root == null)
            return new TreeNode(val);
        
        if(root == null)
            return null;
        
        
        if(root.val < val && !flag){
            if(root.right == null){
                root.right = new TreeNode(val);
                flag = true;
            }
            count++;
            insertIntoBST(root.right,val);
        }
        else{
            if(root.left == null && !flag){
                root.left = new TreeNode(val);
                flag = true;
            }
            count++;
            insertIntoBST(root.left,val);
        }
        return root;
    }
}
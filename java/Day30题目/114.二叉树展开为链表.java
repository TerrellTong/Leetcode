/*
	算法思想：
		1.先找到左子树的最右边的结点
		2.将root.right结点放到1）中找到的最右边的结点
		3.将root.left放到root.right
		4.root = root.right 进行root结点的更换
	
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
    public void flatten(TreeNode root) {
        while(root != null){
            if(root.left == null)
                root = root.right;
            else{
                //找左子树最右边的结点
                TreeNode pre = root.left;
                while(pre.right != null)
                    pre = pre.right;
                //将原来的右子树接到左子树的最右边结点
                pre.right = root.right;
                //将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                //考虑下一个结点
                root  = root.right;
            }
        }
    }
}




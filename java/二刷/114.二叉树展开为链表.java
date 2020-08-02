/*
	算法思想：  
		二刷！还是不会做！
	因为是原地，因此不能占用额外的空间
		1）将左子树插入到右子树的地方
		2）将原来的右子树接到左子树的最右边节点
		3）考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
		
https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--26/
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
            //如果根结点的左孩子没有值，则转到其右孩子
            if(root.left == null)
                root = root.right;
            else{
                TreeNode pre = root.left;
                //找到这个root的左孩子的最右结点
                while(pre.right != null){
                    pre = pre.right;
                }
                //此时，pre指向的是root左孩子的最右结点
                //将root的右孩子放到pre的左孩子
                pre.right = root.right;
                //将root的左孩子放到root的右孩子处
                root.right = root.left;
                //左孩子置空
                root.left = null;
                //开始新一轮遍历
                root = root.right;
            }
        }
    }
}
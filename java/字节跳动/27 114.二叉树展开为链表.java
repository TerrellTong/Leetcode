/*
	算法思想：
		之前做过，知道思想，但是不会实现！！！
		二刷
		
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
                //找到左子树的最右边节点，将右子树添加到左子树的最右边节点上
                TreeNode pre = root.left;
                while(pre.right != null){
                    pre = pre.right;
                }
                //将root的右子树放到pre的右边
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
}
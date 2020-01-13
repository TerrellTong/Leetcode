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
	算法思想：深度优先搜索
	为空就返回高度0，左高度和右高度都是在实体类进行申明的
	由于往下递归的话，如果出现空节点，但是返回的话不能为0，因为其父节点不为空，因此要+1
 */
class Solution {
    public int maxDepth(TreeNode root) {
          if(root == null)
            return 0;
        else{
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return left_height>right_height?left_height+1:right_height+1;
        }
    }
}
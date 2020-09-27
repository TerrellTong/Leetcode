/*
	算法思想：
		根据二叉搜索树的特性，很好的确定，p,q的分布，然后根据分布再进行递归
		不要仅记住，二叉搜索树的中序遍历是顺序的！还要记住根右边的值一定会大于根结点，根左边的节点值是小于根结点
		
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //由于是二叉搜索树，因此，根左边的节点是小于根结点，根右边的节点是大于根结点的
        //如果小于等于0，说明p,q分布在根的两侧，那么根结点一定是最近公共祖先
        if((root.val - p.val) * (root.val - q.val) <= 0)
            return root;
            
        //说明p,q在同一侧,我们然后判断是在哪一侧，然后进行递归即可
        return lowestCommonAncestor(p.val < root.val ? root.left : root.right ,p,q);
    }
}
/*
	算法思想：
		递归！！！之前做过，还是不会！，反正就是不会做！！
		
题解：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/
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
        //root为p,q的公共祖先情况，1）p,q在root的子树的两侧 2） p为root，q在root的左/右子树  3）q为root，p为root的左/右子树
        if(root == null || root == p || root == q)
            return root;
        //开始递归
        //从左子树开始,返回值记为left，返回值为非空，说明在左边找到了p/q
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        //从右子树开始，返回值记为right,返回值为非空，说明在右边找到了p/q
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        //根据返回值left，right可以判断4种情况

        //1)left和right同时为空，说明root的左/右子树不包含p,q，返回null
        if(left == null && right == null)
            return null;
        //如果存在一个不为空，则p,q都在不空的那颗子树
        if(left == null)
            return right;
        if(right == null)
            return left;
        //此时左子树，右子树，都不空，说明在异侧，当前root，为最近公共祖先
        return root;
    }
}
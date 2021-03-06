/*
	算法思想：
		递归，hard，每次节点更新，都是
		
题解：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/er-cha-shu-de-zui-da-lu-jing-he-zhu-yao-li-jie-ti-/
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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
    /**
    Q：左右孩子贡献为什么要大于等于0？
    A: 因为计算从某一节点出发的路径和的时候，计算公式为： 当前节点值 + 左孩子贡献 + 右孩子贡献，
        而左右孩子贡献是「可选的」，也就是说当某一边贡献小于0的时候，我可以在计算路径和时不算这一边
        这种情况也就相当于其贡献为 0，但是注意路径和至少包含「当前节点的值」。
    **/
        int leftMax  = Math.max(0, dfs(root.left));         // 左孩子贡献
        int rightMax = Math.max(0, dfs(root.right));        // 右孩子贡献
        res = Math.max(res, root.val + leftMax + rightMax); // 更新res
		// 返回经过root的单边最大分支给当前root的父节点计算使用
        return root.val + Math.max(leftMax, rightMax);      // 返回当前节点的总贡献
    }

    
}
/*
	算法思想：
		递归，不能先找到结点然后进行判断，因为相等的结点有很多，因此要循环递归即在下面判断isSubtree(s.left)和 isSubtree(s.right)，
		如果不写，则只会判断一次
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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        if(compare(s,t)) return true;

        //由于相等的结点不仅仅只有一个，因此要向下进行SubTree的树进行判断
        return isSubtree(s.left,t)||isSubtree(s.right,t);
    }

    public boolean compare(TreeNode s,TreeNode t){
        //如果s,t都为null.返回true，不能用else！！
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if(s.val != t.val){
            return false;
        }

        boolean is_left = compare(s.left,t.left);
        boolean is_right = compare(s.right,t.right);
        return is_left && is_right;
    }
}












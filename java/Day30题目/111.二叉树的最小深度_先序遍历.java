/*
	算法思想：
		采用先序的思想，做了出来这题
		树的题目，如果dfs做不出来，那么可以考虑先序/中序/后序遍历的思想！
		
	二刷，成功做出来了，没有按照LeetCode参考题目的思路！
	先开始题目看错了，题目要求根结点到最近的叶子节点的路径，因此，我们只需要找到叶子节点之后在进行判断即可！
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
    public int min_len = 0;
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        int len = 1;
        preOrder(root,len);
        return min_len;
    }

    public int preOrder(TreeNode root,int len){
        if(root == null)
            return min_len;
        //如果当前结点的左右子树都是空，则进行min_len的判断
        if(root.right == null && root.left == null){
            if(min_len == 0)
                min_len = len;
            min_len = Math.min(min_len,len);
            return min_len;
        }
        preOrder(root.left,len+1);
        preOrder(root.right,len+1);
        return min_len;
    }
}
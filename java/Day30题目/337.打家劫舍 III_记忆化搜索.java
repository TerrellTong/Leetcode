/*
	算法思想：
		记忆化搜索+递归
	
https://leetcode-cn.com/problems/house-robber-iii/solution/san-chong-fang-fa-jie-jue-shu-xing-dong-tai-gui-hu/
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
    public int rob(TreeNode root) {
        HashMap<TreeNode,Integer> memo = new HashMap();
        return robInternal(root,memo);
    }

    //偷钱只有两种情况：第一种：爷爷和孙子都可以偷，第二种：只有自己的孩子可以偷，两者进行比较！
    public int robInternal(TreeNode root,HashMap<TreeNode,Integer> memo){
        if(root == null)
            return 0;
        //如果memo中存在这个值，则直接返回
        if(memo.containsKey(root))
            return memo.get(root);
        
        int money = root.val;

        if(root.left!=null){
            money += robInternal(root.left.left,memo) + robInternal(root.left.right,memo);
        }
        if(root.right!=null){
            money += robInternal(root.right.left,memo) + robInternal(root.right.right,memo);
        }
        int result = Math.max(money,robInternal(root.left,memo)+robInternal(root.right,memo));
        memo.put(root,result);
        return result;
    }
}
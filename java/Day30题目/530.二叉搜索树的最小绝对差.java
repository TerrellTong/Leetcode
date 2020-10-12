/*
	算法思想：
		二叉树的中序遍历是有序的，因此可以只需要比较相邻的两个数之差即可
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
    List<Integer> res = new ArrayList();
    public int getMinimumDifference(TreeNode root) {
        
        midOrder(root);
        int min = Integer.MAX_VALUE;
        for(int i=1;i<res.size();i++){
            min = Math.min(min,res.get(i)-res.get(i-1));
        }
        return min;
    }

    public void midOrder(TreeNode root){
        if(root == null)
            return;
        midOrder(root.left);
        res.add(root.val);
        midOrder(root.right);
    }
}

/*
	算法思想：
		中序遍历，根据二叉搜索树的特性来解题！！
		如果未进行互换，则二叉搜索树的中序遍历是递增的！！！
		二叉搜索树的特性！！又忘记了！！

假设有一个递增序列 a=[1,2,3,4,5,6,7]。如果我们交换两个不相邻的数字，例如 2 和 6，原序列变成了 a=[1,6,3,4,5,2,7]
那么显然序列中有两个位置不满足 a_i > a_{i+1},在这个序列中体现的6>3 5>2 ，则不满足条件的点是6,2

   如果有两个，我们记为i和j(i<j且 a_i> a_i+1&& a_j >a_j+1)，那么对应被错误交换的节点即为a_i;对应的节
点和a_j+1对应的节点

	
https://leetcode-cn.com/problems/recover-binary-search-tree/solution/zhong-xu-bian-li-by-powcai/
原理：https://leetcode-cn.com/problems/recover-binary-search-tree/solution/hui-fu-er-cha-sou-suo-shu-by-leetcode-solution/
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
    TreeNode firstNode = null;
    TreeNode secondNode = null;
    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);


    public void recoverTree(TreeNode root) {
        inorder(root);
        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;
    }

    public void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        //因为如果没有调换顺序，中序遍历是从小到大的
        //如果firstNode为null,说明此时出现了第一个进行互换的点
        if(firstNode == null && preNode.val > root.val)
            firstNode = preNode;
        //如果firstNode不为null,说明此时出现的是第二个结点
        if(firstNode != null && preNode.val > root.val)
            secondNode = root;
        //preNode表示前一个结点
        preNode = root;
        inorder(root.right);
    }
}
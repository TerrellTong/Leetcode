/*
	算法思想：
		labuladong的思想
		BST的关键思想：BST的中序遍历访问节点值是递增的
		这个题目要使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。即每个节点的值是要加 大于等于后面的值
		
		这样我们需要遍历的节点是递减的，并用一个sum变量，存储之间访问的结点总和！
		对于结点的递减遍历，我们采用将中序的遍历相反，中序是左根右->顺序，如果要递减的话是右根左->降序！
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
    //BST的中序遍历是升序的，我们现在是要找到大于等于node.val的值，因此对于该节点后面的整数和是多少，我们不知道，我们需要降序遍历
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        inorder(root);
        return root;
    }

    public void inorder(TreeNode node){
        if(node == null)
            return;

        //中序是左根右,升序
        //我们要求的是降序，这样我们就是右根左
        inorder(node.right);

        sum += node.val;
        node.val = sum;

        inorder(node.left);
    }
}
/*
	算法思想：
		labuladong的思想
		对于删除，我们套用BST的修改框架
		当找到key的时候，我们就需要进行处理
		主要讨论当前结点存在左右子树的情况，获取右边节点的最小值，然后将最小值节点覆盖到当前root，最后就是转而删除最小值节点！！！
		厉害！！
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        //此时找到了要删除的节点
        if(root.val == key){
            //此时的位置为叶子节点，直接删除即可
            if(root.left == null && root.right == null)
                return null;
            //如果存在一个不为空
            if(root.left == null)
                return root.right;
            if(root.right == null)
                return root.left;
            //此时存在左右孩子，我们为了让搜索树还是一个完整的搜索树
            //由于二叉搜索树的左边都小于根，右边都大于根
            //我们存在两种方式，将左边的最大放到根，或者将右边的最小放到根，则不需要变换了
            
            //获取右边节点的最小值
            TreeNode minNode = getMin(root.right);
            //将当前结点的值，被minNode覆盖
            root.val = minNode.val;
            // 转而去删除 minNode
            root.right = deleteNode(root.right,minNode.val);
        }
        //框架
        if(root.val < key)
            root.right = deleteNode(root.right,key);

        if(root.val > key)
            root.left = deleteNode(root.left,key);
        return root;
    }

    public TreeNode getMin(TreeNode root){
        while(root.left != null)
            root = root.left;
        return root;
    }
}
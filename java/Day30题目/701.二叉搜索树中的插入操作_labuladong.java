/*
	算法思想：
		labuladong的思想
		递归函数的定义：将val值，插入树中，放回root
		不要想插入了之后，树是如何转换的！！！写就可以了！！！
		我陷入到了树的如何转换！！！因此感到了害怕！！！
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
    //找到插入的位置，root为null
    //递归函数的定义：将val值，插入树中，放回root
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //base case
        if(root == null)
            return new TreeNode(val);
        
        //根结点小于val，则找right
        if(root.val < val)
            //如果当前结点的值小于val，我们应该将val插入到root的右子树中
            root.right = insertIntoBST(root.right,val);
        if(root.val > val)
            //同理
            root.left = insertIntoBST(root.left,val);
        return root;
    }
}
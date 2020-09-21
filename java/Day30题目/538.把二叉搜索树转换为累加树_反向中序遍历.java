/*
	算法思想：
		反向中序遍历！！！
		不能够使用先把二叉树用中序遍历求出顺序数组，然后用顺序数组减去对应的值，然后将得到的新数组，再去构建BST。
		而且题目也没有说，修改后的树，还是BST！
		
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
    int add = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root != null){
            convertBST(root.right);
            root.val += add;
            add = root.val;
            convertBST(root.left);
        }
        return root;
    }
}
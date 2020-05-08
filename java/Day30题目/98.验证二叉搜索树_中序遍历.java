/*
	算法思想：
		中序遍历，递归
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
    //pre表示一个之前节点的值，用Long.MIN_VALUE，进行初始化设置
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        //说明左子树不为BST
        if(!isValidBST(root.left))
            return false;
        //说明当前节点的值小于等于pre(左子树的值)
        if(root.val <= pre)
            return false;
        //把此时的值赋给pre
        pre = root.val;
        return isValidBST(root.right);
    }
}


//中序遍历的模板代码
public static void midOrderRe(TreeNode biTree)
	{//中序遍历递归实现
		if(biTree == null)
			return;
		else
		{
			midOrderRe(biTree.left);
			System.out.println(biTree.value);
			midOrderRe(biTree.right);
		}
	}













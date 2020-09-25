/*
	算法思想：
		递归构造树
		之前由根据先序，中序，大致知道应该先找到根结点在中序数组的哪个位置，但是不知道先序的递归下标如何算？
		
	今天看了liweiwei，学习如何计算下标！！ 可以看思路的方法2 ！
		
思路：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/hou-xu-bian-li-python-dai-ma-java-dai-ma-by-liwe-2/
		
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length;
        int postLen = postorder.length;
        return buildTree(inorder,0,inLen-1,postorder,0,postLen-1);
    }

    public TreeNode buildTree(int[] inorder,int inLeft,int inRight,int[] postorder,int postLeft,int postRight){
        if(inLeft > inRight || postLeft > postRight)
            return null;
        
        int pivot = postorder[postRight];
        int pivotIndex = inLeft;

        //找到根结点在中序遍历的位置
        while(inorder[pivotIndex] != pivot){
            pivotIndex++;
        }

        //递归构造树
        TreeNode root = new TreeNode(pivot);
        //根据数组构造左子树
        root.left = buildTree(inorder,inLeft,pivotIndex-1,postorder,postLeft,postRight-inRight+pivotIndex-1);
        //根据数组构造右子树
        root.right = buildTree(inorder,pivotIndex+1,inRight,postorder,postRight-inRight+pivotIndex,postRight-1);

        return root;
    }
}
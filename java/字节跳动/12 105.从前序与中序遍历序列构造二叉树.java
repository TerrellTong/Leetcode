/*
	算法思想：
		堆排序，大根堆
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode build(int[] preorder,int pleft,int pright,int[] inorder,int ileft,int iright){
        if(pleft > pright || ileft > iright)
            return null;
        
        int rootIndex = ileft;
        //在中序遍历中，找到根结点的索引位置
        while(inorder[rootIndex] != preorder[pleft])
            rootIndex++;
        //左子树的数目
        int leftNum = rootIndex - ileft;
        TreeNode root = new TreeNode(preorder[pleft]);
        root.left = build(preorder,pleft+1,pleft+leftNum,inorder,ileft,rootIndex-1);
        root.right = build(preorder,pleft+leftNum+1,pright,inorder,rootIndex+1,iright);
        return root;
    }
}
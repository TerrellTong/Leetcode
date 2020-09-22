/*
	算法思想：
		根据左右孩子的状态来判断这个root是否要放置摄像头
		
题目解释：https://leetcode-cn.com/problems/binary-tree-cameras/solution/chao-ji-hao-li-jie-de-da-an-by-levyjeng/
		
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
    int res = 0;
    public int minCameraCover(TreeNode root) {
        if(dfs(root) == 0)
            res++;
        return res;
    }

    /*
    * dfs返回节点的状态
      0：未被摄像头照到
      1：被摄像头照到
      2：放置了摄像头
    */
    //根据左右孩子的状态来判断这个root是否要放置摄像头
    public int dfs(TreeNode root){
        /*为了保证摄像头数目最少，叶子节点不能放置摄像头
        所以root为null的时候，设置状态为已覆盖*/
        if(root == null)
            return 1;

        //获得左右孩子结点的状态
        int left = dfs(root.left);
        int right = dfs(root.right);

        //左右孩子一共包含了00,01,02,11,12,22这些状态

        //包含了00 01 02 状态，左右孩子只要有一个没有被摄像头照到，则root要放置摄像头
        if(left == 0 || right == 0){
            res++;
            return 2;
        }

        //11状态  由于左右孩子都被照射到了，因此，root可以不放置摄像头，root需要被父结点的摄像头覆盖，设置root的状态为0
        if(left == 1 && right == 1)
            return 0;

        //12,22状态   root可以被孩子覆盖，设置root的状态为1
        if(left + right >= 3)
            return 1;

        //所有节点都包含了，随便返回一个值
        return 0;
    }

}
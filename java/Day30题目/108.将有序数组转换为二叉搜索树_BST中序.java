/*
	算法思想：
		二刷，不会。。。
		二叉搜索树的中序遍历刚好可以输出一个升序数组。所以题目给出的升序数组就是二叉搜索树的中序遍历。
		这里的话怎么知道根节点呢？平衡二叉树，既然要做到平衡，我们只要把根节点选为数组的中点即可。
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
    public TreeNode sortedArrayToBST(int[] nums) {
       return sortedArrayToBST(nums,0,nums.length);
    }

    public TreeNode sortedArrayToBST(int[] nums,int start,int end){
        if(start == end)
            return null;
        //移位找到中点
        int mid = (start+end)>>>1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums,start,mid);
        root.right = sortedArrayToBST(nums,mid+1,end);
        return root;
    }
}

//按照自己的思路也可以实现，代码执行结果不一样不要紧！！
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
    public TreeNode sortedArrayToBST(int[] nums) {
        //二叉搜索树的特点，中序遍历是一个有序集合，nums就是给定的中序遍历
        return dfs(nums,0,nums.length-1);
    }

    public TreeNode dfs(int[] nums,int left,int right){
        if(left > right)
            return null;
        
        int mid = (left + right) >>> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums,left,mid-1);
        root.right = dfs(nums,mid+1,right);
        return root;
    }
}
    






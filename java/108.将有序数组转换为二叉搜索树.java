/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /*
	算法思想：层次遍历
	二叉搜索树的中序遍历刚好输出一个升序数组
	这里的话怎么知道根节点呢？平衡二叉树，既然要做到平衡，我们只要把根节点选为数组的中点即可。

	综上，和之前一样，找到了根节点，然后把数组一分为二，进入递归即可。注意这里的边界情况，包括左边界，不包括右边界。


 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0,nums.length);
    }
    public TreeNode sortedArrayToBST(int[] nums,int start,int end) {
        if(start == end){
            return null;
        }
		//移位实现/2的操作
        int mid = (start+end)>>>1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums,start,mid);
        root.right = sortedArrayToBST(nums,mid+1,end);
        return root;
    }
}

/*
	算法思想：
		怎么说呢，思想还是知道，只是实现出了问题，我是先判断的空，如果先判断为空，可能会出现栈空异常
		记住，先考虑入栈的情况，最后再判断空！

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        while(root != null || !stack.isEmpty()){
            //一直出栈到，某个结点存在右子树
            while(root != null){
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop().right;

        }
        return res;
    }
}
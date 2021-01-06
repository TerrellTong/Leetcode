/*
	算法思想：
		怎么说呢，思想还是知道，只是实现出了问题，我是先判断的空，如果先判断为空，可能会出现栈空异常
		记住，先考虑入栈的情况，最后再判断空！
		按照先序的思想即可！！！

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        while(root != null || !stack.isEmpty()){
            //先入栈
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            //将最后一个左子树结点出队
            root = stack.pop();
            res.add(root.val);
            //root置为根结点
            root = root.right;
        }
        return res;
    }
}
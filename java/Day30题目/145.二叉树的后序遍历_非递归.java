/*
	算法思想：
		非递归，首先找到root的最左边结点，当找到后，不要弹出，要判断这个节点的右子树是否为null,或者其右子树是否为last
		
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        TreeNode last = null;
        while(cur != null || !stack.isEmpty()){
            //找到最左子树
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            //查看栈顶的值，此时的cur是root的最左边左子树
            cur = stack.peek();
            //last保存当前栈顶所弹出的元素
            //cur.right == last是为了避免访问同一个元素而进入到死循环
            //当只剩下根结点后，只通过cur.right == null判断，会进入到死循环
            //1，null，2,3 中当只剩下1时，如果没有cur.right == null 则会继续执行cur = cur.right 但是2被访问过，因此会形成死循环
            if(cur.right == null || cur.right == last){
                res.add(cur.val);
                stack.pop();
                last = cur;
                cur = null;
            }else
                cur = cur.right;
        }
        return res;
    }
}
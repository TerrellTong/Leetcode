/*
	算法思想：
		知道要用栈，但是忘记具体的操作了，没有想到root直接就赋值给了root.right
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
        if(root == null)
            return res;

        while(root != null || !stack.isEmpty()){
            while(root != null){
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //直接在root赋值时，将其置为right节点
            root = root.right;
        }
        return res;
    }
}

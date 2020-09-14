/*
	算法思想：
		非递归，采用栈
		栈的思路我也想到了，找最左结点也考虑到了，没有想到要考虑最左后要考虑右节点
		之前复习过！！
		
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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        List<Integer> res = new ArrayList();
        //!stack.isEmpty()，用于弹出当访问到叶子节点时，此时栈中还有值，避免掉结果
        while(root != null || !stack.isEmpty()){
            //找到当前结点的左子树，一直递归到找不到为止
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            //此时弹出的是root的最左结点
            root = stack.pop();
            res.add(root.val);
            //访问它的右节点
            root = root.right;
        }       
        return res;
    }
}
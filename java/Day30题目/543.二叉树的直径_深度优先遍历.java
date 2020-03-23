 /*
	算法思想：
	深度优先遍历

 */
class Solution {
   class Solution {
    int res = 0; 
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    // 函数dfs的作用是：找到以root为根节点的二叉树的最大深度
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = dfs(root.left);
        int rigthDepth = dfs(root.right);
        res = Math.max(res,leftDepth + rigthDepth);
        return Math.max(leftDepth,rigthDepth) + 1;
    }

}
}

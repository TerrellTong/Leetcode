/*
	算法思想：
		怎么说呢，思想还是知道，只是实现出了问题，我是先判断的空，如果先判断为空，可能会出现栈空异常
		记住，先考虑入栈的情况，最后再判断空！
		
		不同之处：这里的根结点不能直接pop,需要进行判断后才能进行pop
		注意：一定要存最后一次弹出的节点（即根结点），通过这个我们可以防止死循环！

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
        TreeNode last = null;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            //此时root为空，我们需要转换到最后一个结点的右子树
           
            //什么时候添加根结点的元素呢？
            //此时不能直接将栈顶元素退出，因为我们的根结点的值还没有取，如果弹出则丢失值了,所以我们只能用peek
            TreeNode cur = stack.peek();
            //cur.right == null，说明此时右子树没有结点，可以将值其加入
            //并可以将栈顶元素弹出（即该值弹出）
            //如果cur.right == last，说明这个cur结点之前访问过，不然会出现死循环
            if(cur.right == null || cur.right == last){
                res.add(cur.val);
                stack.pop();
                last = cur;
            }else
                root = cur.right;
        }
        return res;
    }
}
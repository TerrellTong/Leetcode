/*
	算法思想：
		层序遍历，经典队列解决
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            //当前层数的大小，由于层数会动态变化，因此，我们要提前记住,
            int size = queue.size();
            List<Integer> list = new ArrayList();
            for(int i=0;i<size;i++){
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if(cur.left != null)
                    queue.offer(cur.left);
                if(cur.right != null)
                    queue.offer(cur.right);
            }
            res.add(list);
        }
        return res;
    }
}
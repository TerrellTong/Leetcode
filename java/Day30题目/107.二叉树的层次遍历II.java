/*
	算法思想：
		层次遍历，二刷，用成栈！！！应该用队列！！不该
		对于层次的变换有了新的理解，采用两个不同的队列即可
		
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //q1,q2表示不同的层
        Queue<TreeNode> q1 = new LinkedList();
        Queue<TreeNode> q2 = new LinkedList();
        List<List<Integer>> res = new ArrayList();
        if(root == null)
            return res;
        q1.offer(root);
        //如果栈不为空，则执行操作
        while(!q1.isEmpty() || !q2.isEmpty()){
            List<Integer> list = new ArrayList();
            //如果q1不为空
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    TreeNode cur = q1.poll();
                    list.add(cur.val);
                    //如果当前左子树不为空，放到下一层（q2）
                    if(cur.left != null)
                        q2.offer(cur.left);
                    if(cur.right != null)
                        q2.offer(cur.right);
                }
            }
            //同理
            else{
                while(!q2.isEmpty()){
                    TreeNode cur = q2.poll();
                    list.add(cur.val);
                    //如果当前左子树不为空，放到下一层（q1）
                    if(cur.left != null)
                        q1.offer(cur.left);
                    if(cur.right != null)
                        q1.offer(cur.right);
                }
            }
            res.add(list);
        }
        Collections.reverse(res);
        return res;
    }
}
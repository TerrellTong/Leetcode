/*
	算法思想：
		层次遍历的运用
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
    public List<Integer> rightSideView(TreeNode root) {
        //构造一个List来存放结果
        List<Integer> res = new ArrayList();

        if(root == null)
            return res;
        //构建两个队列，存储此层结点和下层结点
        Queue<TreeNode> q1 = new LinkedList();
        Queue<TreeNode> q2 = new LinkedList();
        //根节点入队
        q1.offer(root);
        while(!q1.isEmpty() || !q2.isEmpty()){
        //如果q1不为空，则q1出队
        if(!q1.isEmpty()){
            while(!q1.isEmpty()){
                TreeNode tem = q1.poll();
                //先入左结点，后添加右结点
                if(tem.left != null)
                    q2.offer(tem.left);
                if(tem.right != null){
                    q2.offer(tem.right);
                }
                if(q1.isEmpty())
                    res.add(tem.val);
            }
        }else{
             while(!q2.isEmpty()){
                TreeNode tem = q2.poll();
                if(tem.left != null)
                    q1.offer(tem.left);
                if(tem.right != null){
                    q1.offer(tem.right);
                }
                if(q2.isEmpty())
                    res.add(tem.val);
            }
        }
    }
    return res;
}
}













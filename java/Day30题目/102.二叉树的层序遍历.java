/*
	算法思想：
		双队列实现，大致思路理解了，但是有些细小的细节实现有问题
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
        List<List<Integer>> result = new ArrayList();
        Queue<TreeNode> q1 = new LinkedList();
        Queue<TreeNode> q2 = new LinkedList();
        if(root == null)
            return result;
        //根节点入队q1
        q1.offer(root);
        //如果q1,q2不为空就弹出
        while(!q1.isEmpty() || !q2.isEmpty() ){
            List<Integer> temp = new ArrayList();
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    //q1弹出
                    TreeNode temp_node = q1.poll();
                    if(temp_node.left != null)
                        q2.offer(temp_node.left);
                    if(temp_node.right != null)
                        q2.offer(temp_node.right);
                    //当层出队结点入temp
                    temp.add(temp_node.val);
                }
            }else{
                while(!q2.isEmpty()){
                    //q2弹出
                    TreeNode temp_node = q2.poll();
                    if(temp_node.left != null)
                        q1.offer(temp_node.left);
                    if(temp_node.right != null)
                        q1.offer(temp_node.right);
                    //当层出队结点入temp
                    temp.add(temp_node.val);
                }
            }
            result.add(temp);
        }
        return result;
    }
}












/*
	算法思想：
		层次遍历
		
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
    public List<Double> averageOfLevels(TreeNode root) {
        //q1,q2分别表示不同层的节点
        Queue<TreeNode> q1 = new LinkedList();
        Queue<TreeNode> q2 = new LinkedList();
        q1.offer(root);
        List<List<Integer>> res_tmp = new ArrayList();
        while(!q1.isEmpty() || !q2.isEmpty()){
            List<Integer> cur = new ArrayList();
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    TreeNode tmp = q1.poll();
                    cur.add(tmp.val);
                    if(tmp.left != null)
                        q2.offer(tmp.left);
                    if(tmp.right != null)
                        q2.offer(tmp.right);
                }
            }else{
                while(!q2.isEmpty()){
                    TreeNode tmp = q2.poll();
                    cur.add(tmp.val);
                    if(tmp.left != null)
                        q1.offer(tmp.left);
                    if(tmp.right != null)
                        q1.offer(tmp.right);
                }
            }
            res_tmp.add(cur);
        }

        //从res_tmp中获取数据并计算平均数
        List<Double> res = new ArrayList();
        for(List<Integer> list:res_tmp){
            //用double存，防止int的最大值进入后溢出
            double sum = 0;
            for(int i=0;i<list.size();i++){
                sum += list.get(i);
            }
            double result = sum/(double)list.size();
            res.add(result);
        }
        return res;
    }
}
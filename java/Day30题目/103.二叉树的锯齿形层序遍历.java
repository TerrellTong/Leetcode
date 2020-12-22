/*
	算法思想：
		与打印二叉树的层次遍历类似
		Collections.reverse(list) //用于将list的元素翻转！
		

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList();
        Queue<TreeNode> q2 = new LinkedList();
        List<List<Integer>> res = new ArrayList();
        if(root == null)
            return res;
        int level = 0;
        //第一层的数据放到q1中
        q1.offer(root);
        while(!q1.isEmpty() || !q2.isEmpty()){
            if(!q1.isEmpty()){
                List<Integer> curres = new ArrayList();
                while(!q1.isEmpty()){
                    //弹出当前队列的元素
                    TreeNode cur = q1.poll();
                    // if(cur != null){
                        curres.add(cur.val);
                        if(cur.left != null)
                            q2.offer(cur.left);
                        if(cur.right != null)
                            q2.offer(cur.right);
                    // }
                }
                //此时一层已经遍历完毕
                if(level % 2 != 0)
                    Collections.reverse(curres);
                res.add(curres);
                level++;
            }else{
                List<Integer> curres = new ArrayList();
                while(!q2.isEmpty()){
                    //弹出当前队列的元素
                    TreeNode cur = q2.poll();
                    // if(cur != null){
                        curres.add(cur.val);
                        if(cur.left != null)
                            q1.offer(cur.left);
                        if(cur.right != null)
                            q1.offer(cur.right);
                    // }
                }
                //此时一层已经遍历完毕
                if(level % 2 != 0)
                    Collections.reverse(curres);
                res.add(curres);
                level++;
            }
        }
        return res;
    }
}
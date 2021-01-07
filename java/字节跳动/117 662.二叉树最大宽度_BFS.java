/*
	算法思想：
		层次遍历的思想，只不过是，将求层宽，转成了每一层的最右侧编号 - 最左侧编号 + 1
		
题解：https://leetcode-cn.com/problems/maximum-width-of-binary-tree/solution/ceng-ci-bian-li-shi-xian-by-aaron_yu/
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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList();
        //用双端链表，进行存储完全二叉树的下标
        LinkedList<Integer> list = new LinkedList();
        queue.offer(root);
        //根结点的初始下标为1
        list.add(1);
        int res = 1;
        //经典的层次遍历
        while(!queue.isEmpty()){
            int count = queue.size();
            for(int i=0;i<count;i++){
                TreeNode cur = queue.poll();
                //移除队头的下标节点
                Integer curIndex = list.removeFirst();
                if(cur.left != null){
                    queue.offer(cur.left);
                    list.add(curIndex * 2);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                    list.add(curIndex * 2 +1);
                }
            }
            //每一层遍历完成后，我们可以通过对下标进行计算，得到宽度
            //层宽 = 每一层的最右侧编号 - 最左侧编号 + 1
            //当list.size() >=2时进行计算，即宽度大于等于2
            if(list.size() >= 2)
                res = Math.max(res,list.getLast()-list.getFirst()+1);
        }
        return res;
    }
}
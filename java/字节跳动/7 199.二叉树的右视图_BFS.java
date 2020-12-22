/*
	算法思想：
		层次遍历，好像可以直接用size()暂存当前层数的元素即可，不需要浪费空间用两个queue，只需要一个queue！！！
		新发现！！
		
题解：https://leetcode-cn.com/problems/binary-tree-right-side-view/solution/jian-dan-bfsdfs-bi-xu-miao-dong-by-sweetiee/
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
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        List<Integer> res = new ArrayList();
        if(root == null)
            return res;
        while(!queue.isEmpty()){
            //当前层中，元素的个数
            int size = queue.size();
            //通过一个for循环来存储一层的数值
            for(int i=0;i<size;i++){
                TreeNode cur = queue.poll();
                if(cur.left != null)
                    queue.offer(cur.left);
                if(cur.right != null)
                    queue.offer(cur.right);
                if(i == size-1)
                    res.add(cur.val);
            }
        }
        return res;
    }
}
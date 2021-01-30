/*
	算法思想：
		labuladong的思想
		二叉树的关键思想，找到某一个节点，它应该做什么事？
		1）对于这个题而言，我们需要知道自己的子树结构是什么？（对于知道子树结构，我们可以通过对二叉树进行序列化（以一个顺序遍历二叉树）即可！）
		2）我们知道自己的子树结构后，我们还要知道这个子树结构出现过没有？（对于子树结构是否出现，采用HashMap来去重）
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
    Map<String,Integer> map = new HashMap();
    List<TreeNode> res = new ArrayList();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    //重复子树的定义：二叉树的序列化的结果不重复
    //二叉树的模样：通过序列化即可，将null用#代替，用‘，’分割二叉树的节点值

    public String traverse(TreeNode root){
        if(root == null)
            return "#";

        //要知道二叉树的模样，我们要先知道自己的左孩子，右孩子分别是什么，然后加入根结点即可
        String left = traverse(root.left);
        String right = traverse(root.right);
        String result = left+","+right+","+root.val;

        int count = map.getOrDefault(result,0);
        if(count == 1)
            res.add(root);

        map.put(result,count+1);
        return result;
    }
}
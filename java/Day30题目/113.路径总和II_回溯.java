/*
	算法思想：
		递归构造树
		之前由根据先序，中序，大致知道应该先找到根结点在中序数组的哪个位置，但是不知道先序的递归下标如何算？
		
	今天看了liweiwei，学习如何计算下标！！ 可以看思路的方法2 ！
		
思路：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/hou-xu-bian-li-python-dai-ma-java-dai-ma-by-liwe-2/
		
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
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root,sum,0,new ArrayList());
        return res;
    }

    public void dfs(TreeNode root,int sum,int cur_sum,List<Integer> cur){
        if(root == null)
            return;

        //不能直接当判断大于sum，就返回，因为存在负数！！
        // if(Math.abs(cur_sum) > Math.abs(sum))
        //     return;


        cur_sum += root.val;
        cur.add(root.val);


        if(cur_sum == sum){
            if(root.right == null && root.left == null){
                res.add(new ArrayList(cur));
                cur.remove(cur.size()-1);
                return;
            }
        }







        dfs(root.left,sum,cur_sum,cur);
        // cur.remove(cur.size()-1);

        // cur.add(root.val);
        dfs(root.right,sum,cur_sum,cur);
        cur.remove(cur.size()-1);

    }
}
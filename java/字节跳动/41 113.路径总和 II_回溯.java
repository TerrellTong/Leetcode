/*
	算法思想：
		回溯
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
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root,sum,new ArrayList(),0);
        return result;
    }

    public void dfs(TreeNode root,int sum,List<Integer> cur,int res){
        if(root == null)
            return;
        res += root.val;
        cur.add(root.val);
        if(res == sum && root.left == null && root.right == null){
            result.add(new ArrayList(cur));
            cur.remove(cur.size()-1);
            return;
        }
        //不能直接返回，因为会出现负数！！
        // if( Math.abs(res) > Math.abs(sum)){
        //     cur.remove(cur.size()-1);
        //     return;
        // }

        if(root.left != null){
            dfs(root.left,sum,cur,res);
        }

        if(root.right != null){
            dfs(root.right,sum,cur,res);
        }

        
        res -= root.val;
        cur.remove(cur.size()-1);
    }
}
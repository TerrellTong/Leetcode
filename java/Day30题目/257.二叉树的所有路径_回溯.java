/*
	算法思想：
		回溯，题目
		
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
    public List<String> res = new ArrayList();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null)
            return res;
        List<Integer> cur = new ArrayList();
        dfs(root,cur);
        return res;
    }

    public void dfs(TreeNode root,List<Integer> cur){
        cur.add(root.val);
        if(root.right == null && root.left == null){
            //用StringBuilder来构建路径
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<cur.size();i++){
                sb.append(cur.get(i));
                if(i != cur.size()-1)
                    sb.append("->");
            }
            res.add(sb+"");
            return;
        }
        
        if(root.left != null){
            // cur.add(root.val);
            dfs(root.left,cur);
            cur.remove(cur.size()-1);
        }

        if(root.right != null){
            // cur.add(root.val);
            dfs(root.right,cur);
            cur.remove(cur.size()-1);
        }
    }
}
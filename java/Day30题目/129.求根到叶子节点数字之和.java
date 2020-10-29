/*
	算法思想：
		回溯，找到每一种情况
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
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        dfs(root,new ArrayList());
        int result = 0;
        //获取list的每一个值，然后相加
        for(List<Integer> list:res){
            int tmp = 0;
            for(int i=0;i<list.size();i++){
                tmp += list.get(i)*Math.pow(10,(list.size()-i-1));
            }
            result += tmp;
        }
        return result;
    }

    public void dfs(TreeNode root,List<Integer> cur){
        if(root == null){
            cur.add(0);
            return;
        }
        cur.add(root.val);
        if(root.left == null && root.right == null){
            res.add(new ArrayList(cur));
            return;
        }


        dfs(root.left,cur);
        cur.remove(cur.size()-1);

        dfs(root.right,cur);
        cur.remove(cur.size()-1);
    }
}

//递归，题解  传一个参数，传上一层计算的值
class Solution {
    int tmp;
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }

    //i是上一层计算的值
    public int dfs(TreeNode root,int i){
        if(root == null)
            return 0;
        int tmp = i*10 + root.val;
        if(root.left == null && root.right == null)
            return tmp;
        return dfs(root.left,tmp) + dfs(root.right,tmp);

    }
}
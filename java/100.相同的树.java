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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //空树
        if(p == null && q == null)
            return true;
        //如果q,p中有一个不为空，则返回false
        else if(p==null||q==null)
            return false;
        //如果p,q结点的值相同就递归，否则返回false
        else if(p.val == q.val){
                return (isSameTree(p.left,q.left)&& isSameTree(p.right,q.right));
            } 
        else   
            return false;
    }
}
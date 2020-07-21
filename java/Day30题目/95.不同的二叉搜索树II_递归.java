/*
	算法思想：
		递归思想！
		从构建一颗树，变成构建多棵树，
		然后每棵树的左右子树如何构建
		
https://leetcode-cn.com/problems/unique-binary-search-trees-ii/solution/cong-gou-jian-dan-ke-shu-dao-gou-jian-suo-you-shu-/
https://leetcode-cn.com/problems/unique-binary-search-trees-ii/solution/bu-tong-de-er-cha-sou-suo-shu-ii-by-leetcode-solut/	
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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0)
            return new LinkedList<TreeNode>();
        return generateTrees(1,n);
    }

    //进行递归
    public List<TreeNode> generateTrees(int start,int end){
        List<TreeNode> allTrees = new LinkedList();
        if(start > end){
            allTrees.add(null);
            return allTrees;
        }

        //枚举可行的根节点
        //每一个根节点都可以构建一棵树，根节点加入到allTrees中
        for(int i=start;i<=end;i++){
            //获取所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start,i-1);

            //获取所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i+1,end);

            //从左子树集合中选一棵左子树，从右子树中选择一棵右子树，拼接到根节点上
            //把每个数字作为根节点，然后把所有可能的左子树和右子树组合起来即可。
            //我们固定一个左孩子，遍历右子树列表，那么以当前为root根结点的树个数就为left.size() * right.size()个。
            for(TreeNode left:leftTrees){
                for(TreeNode right:rightTrees){
                    TreeNode curTree = new TreeNode(i);
                    curTree.left = left;
                    curTree.right = right;
                    allTrees.add(curTree);
                }
            }
        }
        return allTrees;
    }
}






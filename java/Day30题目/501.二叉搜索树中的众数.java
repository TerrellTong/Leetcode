/*
	算法思想：
		中序遍历，然后找到频率最大的数，然后将中序遍历的值放入Map中，比较
		
		
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
    Map<Integer,Integer> map = new HashMap();
    List<Integer> tmp = new ArrayList();
    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[]{};
        minorder(root);
        int[] res = new int[tmp.size()];
        for(int i=0;i<res.length;i++){
            res[i] = tmp.get(i);
        }

        int maxCount = 1;
        int compareCount = res[0];
        int tmpcount = 1;
        for(int i=1;i<res.length;i++){
            
            if(res[i] == compareCount){
                tmpcount++;
                maxCount = Math.max(tmpcount,maxCount);
            }else {
                //如果两者不相等，则重新计数
                compareCount = res[i];
                tmpcount = 1;
            }
        }

        for(int result:tmp){
            int count = map.getOrDefault(result,0);
            count++;
            map.put(result,count);
        }

        List<Integer> end = new ArrayList();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(maxCount == entry.getValue())
                end.add(entry.getKey());
        }

        int[] results = new int[end.size()];
        for(int i=0;i<results.length;i++){
            results[i] = end.get(i);
        }

        return results;

    }

    public void minorder(TreeNode root){
        if(root == null)
            return;

        minorder(root.left);
        tmp.add(root.val);
        minorder(root.right);
    }
}
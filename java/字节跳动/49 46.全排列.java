/*
	算法思想：
		全排列，注意used数组！！！
*/


class Solution {
    boolean[] used;
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        dfs(nums,new ArrayList(),0);
        return res;
    }

    public void dfs(int[] nums,List<Integer> cur,int pos){
        if(pos == nums.length){
            res.add(new ArrayList(cur));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                used[i] = true;
                cur.add(nums[i]);
                dfs(nums,cur,pos+1);
                used[i] = false;
                cur.remove(cur.size()-1);
            }
        }
    }
}
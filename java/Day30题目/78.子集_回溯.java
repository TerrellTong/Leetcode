/*
	算法思想：
		回溯思想，类似于组合问题！
		
*/


class Solution {
    List<List<Integer>> res = new ArrayList();
    boolean[] used;
    public List<List<Integer>> subsets(int[] nums) {
        used = new boolean[nums.length];
        res.add(new ArrayList());
        dfs(0,new ArrayList(),nums);
        return res;
    }

    public void dfs(int index,List<Integer> cur,int[] nums){
        if(index == nums.length){
            return;
        }

        for(int i=index;i<nums.length;i++){
                cur.add(nums[i]);
                res.add(new ArrayList(cur));
                dfs(i+1,cur,nums);
                cur.remove(cur.size()-1);
            
        }

    }
}
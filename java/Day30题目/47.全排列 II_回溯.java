/*
	算法思想：
		题目中给的条件是数组中存在重复元素
		回溯，排列的去重多了一个！used[i-1]，而组合的没有！！
*/


class Solution {
    List<List<Integer>> res = new ArrayList();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,0,new ArrayList());
        return res;
    }

    public void dfs(int[] nums,int index,List<Integer> cur){
        if(index == nums.length){
            res.add(new ArrayList(cur));
            return;
        }
        for(int i= 0;i<nums.length;i++){
			//排列的去重
            if(i>0 && nums[i]== nums[i-1] && !used[i-1])
                continue;
            if(!used[i]){
                cur.add(nums[i]);
                used[i] = true;
                dfs(nums,index+1,cur);
                cur.remove(cur.size()-1);
                used[i] = false;
            }
        }
    }
}
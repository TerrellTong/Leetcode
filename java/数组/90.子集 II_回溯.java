/*
	算法思想：
		回溯，注意去重！
		

*/

class Solution {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,0,new ArrayList(),visited);
        return res;
    }

    public void dfs(int[] nums,int start,List<Integer> cur,boolean[] visited){
        res.add(new ArrayList(cur));
        for(int i=start;i<nums.length;i++){
            //去重
            if(i > start && nums[i] == nums[i-1])
                continue;

            cur.add(nums[i]);
            dfs(nums,i+1,cur,visited);
            cur.remove(cur.size()-1);
        }
    }
}

/*
	算法思想：
		回溯，之前做过类似的题目，成功实现了，但是有的测试用例出现了超时限制：1）我自己在写的时候是从每一个开始递归，题解在写的时候，是直接从-1开始，使其减少了一次循环
		2）在遇到相同的数的时候，采用hashSet进行去重操作，当遇到相同的数时，就继续下一步操作！
		
题目思路：https://leetcode-cn.com/problems/increasing-subsequences/solution/jin-tian-wo-you-shuang-ruo-zhuo-neng-miao-dong-la-/
*/


class Solution {
    public List<List<Integer>> res = new ArrayList();
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> cur = new ArrayList();
        dfs(-1,cur,nums);
        return res;
    }

    public void dfs(int idx,List<Integer> cur,int[] nums){
        //如果当前的list的长度大于2，则添加到res中
        if(cur.size() >= 2){
            res.add(new ArrayList<>(cur));
        }

        Set<Integer> set = new HashSet();
        for(int i=idx+1;i<nums.length;i++){
            //如果出现相同的数，则继续走下一步，从而进行去重操作
            //如果当前值已经在set中了，则终止此路径继续搜索！
            if(set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);
            if(idx == -1 || nums[idx] <= nums[i]){
                cur.add(nums[i]);
                dfs(i,cur,nums);
                //移除cur的最后一个数字
                cur.remove(cur.size()-1);
            }
        }
    }
}
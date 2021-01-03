/*
	算法思想：
		回溯，这个题目不像全排列，有的位置是需要剪枝的
		此时的start，作为i的起始变量，不想当与全排列的，i是index
		要学会如何剪枝！！
		
	有些朋友可能会疑惑什么时候使用 used 数组，什么时候使用 begin 变量。这里为大家简单总结一下：
		排列问题，讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为不同列表时），需要记录哪些数字已经使用过，此时用 used 数组；
		组合问题，不讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为相同列表时），需要按照某种顺序搜索，此时使用 begin 变量。
	
https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
*/


class Solution {
    List<List<Integer>> res = new ArrayList();
    Set<List<Integer>> set = new HashSet();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> cur = new ArrayList();
        dfs(candidates,target,cur,0,0);
        return res;
    }

    public void dfs(int[] candidates,int target,List<Integer> cur,int sum,int begin){
        if(sum == target){
            res.add(new ArrayList(cur));
            return;
        }

        if(sum > target)
            return;

        //开始遍历
        for(int i=begin;i<candidates.length;i++){
            cur.add(candidates[i]);
            sum += candidates[i];
			// 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates,target,cur,sum,i);
            sum -= candidates[i];
            cur.remove(cur.size()-1);
        }
    }
}
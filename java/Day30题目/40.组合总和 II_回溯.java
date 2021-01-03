/*
	算法思想：
		回溯，这个题目不像全排列，有的位置是需要剪枝的
		此时的start，作为i的起始变量，不想当与全排列的，i是index
		要学会如何剪枝！！（i > begin 且 c[i-1] == c[i] 可以进行剪枝）
		
	有些朋友可能会疑惑什么时候使用 used 数组，什么时候使用 begin 变量。这里为大家简单总结一下：
		排列问题，讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为不同列表时），需要记录哪些数字已经使用过，此时用 used 数组；
		组合问题，不讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为相同列表时），需要按照某种顺序搜索，此时使用 begin 变量。
	
https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
*/


class Solution {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0,candidates,target,new ArrayList(),0);
        return res;
    }

    public void dfs(int begin,int[] candidates,int target,List<Integer> cur,int sum){
        if(target == sum){
            res.add(new ArrayList(cur));
            return;
        }

        //如果求和的总数大于target，直接返回
        if(sum > target)
            return;

        for(int i=begin;i<candidates.length;i++){
            //当i>begin是，且candidate[i] == candidiates[i-1]
            //说明可以进行去重
            //1,1,6可以出现，是因为进入到第二个1时，i=begin!
            if(i > begin && candidates[i] == candidates[i-1])
                continue;
            sum += candidates[i];
            cur.add(candidates[i]);
			// 注意：由于每一个元素只能使用一次，下一轮搜索的起点为i+1,与39区别开来
            dfs(i+1,candidates,target,cur,sum);
            sum -= candidates[i];
            cur.remove(cur.size()-1);
        }
    }
}
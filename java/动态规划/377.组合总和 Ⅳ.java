/*
	算法思想：
		记忆化搜索
		
		这题是找到组合数，与之前的问题不同，之前做的都是比较选择最小，这里是要求累加！！！
		
题解： https://leetcode-cn.com/problems/combination-sum-iv/solution/ti-jie-yi-se-de-dong-tai-gui-hua-an-lai-ge-dfsde-b/ （java）
		为什么target== 0 要返回1 ？
		https://leetcode-cn.com/problems/combination-sum-iv/solution/dong-tai-gui-hua-python-dai-ma-by-liweiwei1419/
*/

class Solution {
    int[] memo;
    public int combinationSum4(int[] nums, int target) {
        memo = new int[target+1];
        Arrays.fill(memo,-1);
        return tryCombination(nums,target);
    }

    public int tryCombination(int[] nums,int target){
        if(target == 0)
            return 1;

        //此时不能再次进行拆分了
		//注意这种不能继续拆分的情况的做法！！！
        if(target < 0)
            return -1;

        if(memo[target] != -1)
            return memo[target];

        int res = 0;
        for(int i=0;i<nums.length;i++){
            //判断当前数-nums[i]后所需要的次数
            int tmp = tryCombination(nums,target-nums[i]);
            //tmp != -1说明可以进行相应的拆分
			//这题是找到组合数，与之前的问题不同，之前做的都是比较选择最小，这里是要求累加！！！新题型get!!
			//注意要判断-1，因为为-1，说明此时的方案是行不通的！！
            if(tmp != -1)
                res += tmp;
        }

        memo[target] = res;
        return memo[target];
    }
}

//回溯，超时！！！
class Solution {
    List<List<Integer>> list = new ArrayList();
    public int combinationSum4(int[] nums, int target) {
        dfs(nums,target,new ArrayList(),0);
        return list.size();
    }

    public void dfs(int[] nums,int target,List<Integer> cur,int sum){
        if(sum == target){
            list.add(new ArrayList(cur));
            return;
        }

        if(sum >target)
            return;

        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            cur.add(nums[i]);
            dfs(nums,target,cur,sum);
            cur.remove(cur.size()-1);
            sum -= nums[i];
        }
    }
}
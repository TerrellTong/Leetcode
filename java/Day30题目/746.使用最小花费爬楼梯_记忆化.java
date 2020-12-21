/*
	算法思想：
		记忆化搜索，按照青蛙跳台阶思考
*/

class Solution {
    int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length+1];
        Arrays.fill(memo,-1);
        return dfs(cost,cost.length);
    }

    public int dfs(int[] cost,int pos){
        //递归终止条件
        if(pos < 0){
            return 0;
        }
        
        if(pos < cost.length && memo[pos] != -1)
            return memo[pos];

        int pos1 = dfs(cost,pos-1);
        int pos2 = dfs(cost,pos-2);
        if(pos == cost.length)
            memo[pos] = Math.min(pos1,pos2);
        else
            memo[pos] = Math.min(pos1,pos2) + cost[pos];
        return memo[pos];
    }
}
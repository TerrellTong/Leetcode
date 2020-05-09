/*
	算法思想：
		动态规划，状态转移方程，今天的购买取决于后面的行程==>从后面往前推
	解析：
		https://leetcode-cn.com/problems/minimum-cost-for-tickets/solution/java-dong-tai-gui-hua-si-lu-bu-zou-cong-hou-xiang-/
*/
 
class Solution {

    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        //出去的最大一天
        int maxDay = days[len-1];
        //出去的最小一天
        int minDay = days[0];
        int[] dp = new int[maxDay+31];
        //从后往前推，因为今天买多少，完全取决于后面的天数选择
        for(int d=maxDay,i=len-1;d>=minDay;d--){
            //i表示days的索引
            if(d == days[i]){
                dp[d] = Math.min(dp[d+1]+costs[0],dp[d+7]+costs[1]);
                dp[d] = Math.min(dp[d],dp[d+30]+costs[2]);
                i--;//递减一天
            }else
                dp[d] = dp[d+1];//这一天不需要出门
        }
        return dp[minDay];
    }

}













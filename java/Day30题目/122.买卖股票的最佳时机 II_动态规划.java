/*
	算法思想：
		动态规划，用一个维度进行状态存储

题解：

*/

class Solution {
    public int maxProfit(int[] prices) {
        //0:表示当前没有股票
        //1:表示当前持有股票
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1;i < prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
        }
        return dp[prices.length-1][0];
    }
}
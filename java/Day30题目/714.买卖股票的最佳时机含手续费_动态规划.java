/*
	算法思想：
		动态规划，与股票买卖II类似，多了一个fee
*/


class Solution {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        //0:表示当前没有股票，1表示当前持有股票
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for(int i=1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]-fee);
            dp[i][1] = Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
        }

        return dp[len-1][0];
    }
}
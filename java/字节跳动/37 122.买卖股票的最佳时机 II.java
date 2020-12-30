/*
	算法思想：
		注意有2次，k次的状态定义与无限次和1次不同！！！
*/


class Solution {
    public int maxProfit(int[] prices) {
        //注意有2次，k次的状态定义与无限次和1次不同！！！
        int[][] dp = new int[prices.length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for(int i=1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[prices.length-1][0];
    }
}
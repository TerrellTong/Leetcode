/*
	算法思想：
		此时是无限次交易，可以套用无限次的模板
		但是需要多一个冷冻期的状态！！！
*/


class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        //三种状态，0:没有股票，不在冷冻期，1:没有股票，在冷冻期，2:存在股票
        int[][] dp = new int[prices.length][3];
        //base case
        dp[0][2] = -prices[0];
        for(int i=1;i<prices.length;i++){
            //没有股票，冷冻期/非冷冻期两种状态
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            //冷冻期的股票，可以是卖出股票/上一个冷冻期
            //这样做可以ac，但是冷冻期只会持续一天，我们可以省略dp[i-1][1]！！！
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][2]+prices[i]);
            //持有股票,买了股票
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][0]-prices[i]);
        }
        return Math.max(dp[prices.length-1][1],dp[prices.length-1][0]);
    }
}
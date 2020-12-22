/*
	算法思想：
		买卖股票，由于只能买卖一次，因此持有的状态不能是从前一天的未持有状态过来！！！
		

*/

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        //0表示未持有，1表示持有，只有一次
        int[][] dp = new int[prices.length][2];

        //初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i=1;i<prices.length;i++){
            //当前未持有
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            //只允许交易一次，因此手上的现金数就是当天的股价的相反数
			//买卖多次，为Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[prices.length-1][0];
    }
}
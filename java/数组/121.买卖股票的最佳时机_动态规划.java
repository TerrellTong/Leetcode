/*
	算法思想：
		动态规划
		
题解：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/bao-li-mei-ju-dong-tai-gui-hua-chai-fen-si-xiang-b/
		

*/

class Solution {
    public int maxProfit(int[] prices) {
        //dp[i][j]表示: 第i天的状态 [i][0]:表示当前天数，未持有股票，[i][1]:表示当前天数持有了股票
        //dp[i][j]的值表示，最大利润
        int[][] dp = new int[prices.length][2];

        if(prices.length == 0)
            return 0;

        //dp[][]初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for(int i=1;i<prices.length;i++){
            //第i天未持有股票，此状态有两种转移形式，可以从上一种未持有转移过来，或者是上一天持有，今天卖了
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            
            //第i天持有股票，此状态有两种转移形式，可以从上一种未持有转移过来，或者是今天买了股票，（只能交易一次！）
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
        }

        return dp[prices.length-1][0];

    }
}


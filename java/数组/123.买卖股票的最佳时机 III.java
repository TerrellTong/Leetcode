/*
	算法思想：
		动态规划，与之前的类似
		当MAX_VALUE溢出时，用1e9 ，不可达！！
		
题解：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/dong-tai-gui-hua-by-liweiwei1419-7/
		

*/

class Solution {
    public int maxProfit(int[] prices) {
        //dp[i][j]表示: 第i天的状态 [i][0]:表示当前天数，未持有股票(未开始交易)，[i][1]:表示当前天数持有了股票(第一次)
        //[i][2],表示第一次卖出(未持有)  [i][3] 表示第二次持有   [i][4]表示第二次卖出(未持有)
        //dp[i][j]的值表示，最大利润
        int[][] dp = new int[prices.length][5];

        if(prices.length == 0)
            return 0;
		
		//比MIN_VALUE大一点点，不会溢出，当MAX_VALUE溢出时，用1e9
        int inf=-(int)1e9;

        //dp[][]初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = inf;
        dp[0][3] = inf;
        

        for(int i=1;i<prices.length;i++){
            //第i天未持有股票(初始状态)，此状态只有一种形式，昨天没有持有
            dp[i][0] = dp[i-1][0];
            
            //第i天持有股票，此状态有两种转移形式，可以从上一种未持有转移过来，或者是今天买了股票，
            //下面的转移思想都类似的
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);

            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]+prices[i]);

            dp[i][3] = Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);

            dp[i][4] = Math.max(dp[i-1][4],dp[i-1][3]+prices[i]);
        }

        return Math.max(dp[prices.length-1][0],Math.max(dp[prices.length-1][2],dp[prices.length-1][4]));
    }
}


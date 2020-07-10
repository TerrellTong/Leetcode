/*
	算法思想：
		动态规划！
		dp[]数组的大小声明,
			如果循环的时候是<len，则dp[len]
			如果循环是<=len ，则dp[len+1]

https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/zui-jia-mai-mai-gu-piao-shi-ji-han-leng-dong-qi-4/

		
*/
class Solution {
    public int maxProfit(int[] prices) {
        //如果价格数组为空，则返回0
        if(prices.length == 0)
            return 0;
        int len = prices.length;
        int[][] dp = new int[len][3];
        //初始化
        //买入股票:负收益；卖股票：正收益
        //第i天的利润，由i-1天转移过来的
        dp[0][0] = -prices[0];
        for(int i=1;i<len;i++){
            //dp[i][0]:表示第i天持有股票的最大利润且拥有一支股票，它有两种情况转换过来，第i-1天就持有这个股票/第i天才买入->i-1为不持有且无冷冻期
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]-prices[i]);
            //dp[i][1]:表示第i天持有股票的最大利润且没有股票，而且在冷冻期,它只有一种状况，第i-1天就卖出这个股票
            dp[i][1] = dp[i-1][0]+prices[i];
            //dp[i][2]:表示第i天持有股票的最大利润且没有股票，而且不处于冷冻期,它在i-1天处于冷冻期/在i-1天就没有股票且没在冷冻期
            dp[i][2] = Math.max(dp[i-1][1],dp[i-1][2]);
        }
        //因此在最后一天(第n-1天结束后)，手上如果拥有股票是毫无意义的，因此只需要比较没有股票的情况
        return Math.max(dp[len-1][1],dp[len-1][2]);
    }
}






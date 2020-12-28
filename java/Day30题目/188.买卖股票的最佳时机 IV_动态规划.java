/*
	算法思想：
		动态规划，III和IV可以归为一类！！将k=3放到III中即可！
		
*/

class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n < 2 || k == 0)
            return 0;
        //因为一次交易需要两天，如果k> n/2 相当于没有限制
        if( k >= n/2){
            return Norestrict(prices);
        }
        //表示k次的状态
        int[][] dp = new int[k+1][2];
        for(int i=0;i<=k;i++)
            dp[i][1] = Integer.MIN_VALUE;

        for(int price : prices){
            for(int j=1;j<=k;j++){
                dp[j][1] = Math.max(dp[j][1],dp[j-1][0]-price);
                //当天卖出股票，不增加交易次数！
                dp[j][0] = Math.max(dp[j][0],dp[j][1]+price);
            }
        }
        return dp[k][0];

    }

    public int Norestrict(int[] prices){
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
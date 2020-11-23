/*
	算法思想：
		其余几次I,II,III 在"数组"中！！
		第k次买入： 从第k-1次卖出转换而来，或者第k次买入后保持不动
		dp[i][j-1][1] = max(dp[i-1][j-1][1],dp[i-1][j-1][0]-prices[i])

		第k次卖出： 从第k次买入后转换而来，或者是第k次卖出后保持不动
		dp[i][j][0] = max(dp[i-1][j][0],dp[i-1][j-1][1]+prices[i])

		第k+1次买入：
		dp[i][j][1] = max(dp[i-1][j][1],dp[i-1][j][0]-prices[i])

作者：wang_ni_ma
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/si-chong-jie-fa-tu-jie-188mai-mai-gu-piao-de-zui-j/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
		
*/

class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int n = prices.length;
        //1表示买入(持有)，0表示卖出（即未持有）
        //K为非常大时转为无限次交易
        if(k >= n/2){
            int dp0 = 0,dp1 = -prices[0];
            for(int i=1;i<n;i++){
                int tmp = dp0;
                dp0 = Math.max(dp0,dp1+prices[i]);
                dp1 = Math.max(dp1,dp0-prices[i]);
            }
            return Math.max(dp0,dp1);
        }

        //定义二维数组
        //1表示买入(持有)，0表示卖出（即未持有）
        int[][] dp = new int[k+1][2];
        //数组初始化
             for(int i=0;i<=k;++i) {
            dp[i][0] = 0;
            dp[i][1] = -prices[0]; 
        }

        for(int i=1;i<prices.length;i++){
            for(int j=k;j>0;j--){
                //一买，一卖，正好对应的维度有变化，第k次
                //把第i天的那个维度省略了 ！！
				/*
				第一次买入：从初始状态转换而来，或者第一次买入后保持不动
				dp[i][0][1] = max(dp[i-1][0][1],dp[i-1][0][0]-prices[i])

				第一次卖出：从第一次买入转换而来，或者第一次卖出后保持不动
				dp[i][1][0] = max(dp[i-1][1][0],dp[i-1][0][1]+prices[i])

				第二次买入：从第一次卖出转换而来，或者第二次买入后保持不动
				dp[i][1][1] = max(dp[i-1][1][1],dp[i-1][1][0]-prices[i])

				第二次卖出：从第二次买入转换而来，或者第二次卖出后保持不动
				dp[i][2][0] = max(dp[i-1][2][0],dp[i-1][1][1]+prices[i])

				
				第k次买入： 从第k-1次卖出转换而来，或者第k次买入后保持不动
				dp[i][j-1][1] = max(dp[i-1][j-1][1],dp[i-1][j-1][0]-prices[i])

				第k次卖出： 从第k次买入后转换而来，或者是第k次卖出后保持不动
				dp[i][j][0] = max(dp[i-1][j][0],dp[i-1][j-1][1]+prices[i])
				*/
                //第k次卖出，即结果
                dp[j][0] = Math.max(dp[j][0],dp[j-1][1]+prices[i]);
                //第k次买入
                dp[j-1][1] = Math.max(dp[j-1][1],dp[j-1][0]-prices[i]);
            }
        }
        return dp[k][0];
    }
}
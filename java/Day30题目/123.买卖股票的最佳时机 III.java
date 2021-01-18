/*
	算法思想：
		按照k次的思想做的，只有买入才算是一次交易，按照次数来设计动态转移！与1次和无限次不同！！！
	
*/


class Solution {
    public int maxProfit(int[] prices) {
        //k次，2次都是用次数作为状态转移
        //只要买入才算次数
        int[][] dp = new int[3][2];


        //初始化
        for(int i=0;i<3;i++){
            dp[i][1] = Integer.MIN_VALUE;
        }

        for(int price:prices){
            for(int i=1;i<3;i++){
                //只有买入才算是一次交易
                dp[i][0] = Math.max(dp[i][0],dp[i][1]+price);
                dp[i][1] = Math.max(dp[i][1],dp[i-1][0]-price);
            }
        }

        return dp[2][0];
    }
}
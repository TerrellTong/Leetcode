/*
	算法思想：
		按照左神零钱兑换II的思路解决的。
		我们先找完一类，例如[1,2,5]先把所有的1找完，看有多少种情况，然后再也不用1了！！，这样可以减少重复问题，也方便自己理解，但是自己的记忆化还是会超时！！
		
	题解：https://dairongpeng.github.io/algorithm-note/12#131   参照凑货币问题！
	
*/


class Solution {
    int min = Integer.MAX_VALUE;
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount+1][coins.length+1];
        for(int i=0;i<dp.length;i++)
            for(int j=0;j<dp[0].length;j++)
                dp[i][j] = -1;
        tryCoin(coins,amount,0,0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void tryCoin(int[] coins,int amount,int pos,int count){
        if(dp[amount][pos] != -1)
            return;

        if(amount == 0){
            min = Math.min(count,min);
            dp[amount][pos] = min;
        }

        if(pos == coins.length){
            return;
        }



        for(int zhang = 0;zhang * coins[pos] <= amount;zhang++)
            tryCoin(coins,amount-(zhang * coins[pos]),pos+1,zhang+count);

    }
}
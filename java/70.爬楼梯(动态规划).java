/*
	思想：
		动态规划问题，只用dp[]数组即可（非递归方法）
		把状态转移方程的起始条件给出来即可，从1开始考虑问题
		例：
			如果想从3开始遍历，则我们需要知道，dp[1]和dp[2]的值即可
*/

class Solution {
    public int climbStairs(int n) {
        int result ;
        //如果n为1,则只有一种情况
        if(n == 1)
            return 1;
		//
        int dp[] = new int [n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n ; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}


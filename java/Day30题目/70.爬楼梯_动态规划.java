/*
	算法思想：
		动态规划，二刷
	当前一步，可能有一步跨过来/两步跨过来
	因此 dp[i] = dp[i-1]+dp[i-2];
	
*/
class Solution {
    public int climbStairs(int n) {
        if(n == 1)
            return 1;
        int[] dp =new int [n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++)
            dp[i] = dp[i-1] + dp[i-2];
        return dp[n];
    }
}




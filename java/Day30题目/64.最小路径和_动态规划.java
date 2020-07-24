/*
	算法思想：
		动态规划：之前做过许多类似的！

*/

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        //初始化
        dp[0][0] = grid[0][0];
        //边界状况考虑
        for(int i=1;i<m;i++)
            dp[i][0] = dp[i-1][0] + grid[i][0];
        for(int j=1;j<n;j++)
            dp[0][j] = dp[0][j-1] + grid[0][j];
        //开始遍历
        //状态转移方程：dp[i][j] = Math.min(dp[i][j],Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j])
        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++)
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
        return dp[m-1][n-1];
    }
}
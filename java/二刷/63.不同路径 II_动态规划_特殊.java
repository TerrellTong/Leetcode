/*
	算法思想：
		动态规划！！二刷，还是不会做，我自己想的思路是dfs，但是多条路径无法处理！
		
https://leetcode-cn.com/problems/unique-paths-ii/solution/jian-dan-dpbi-xu-miao-dong-by-sweetiee/
*/
class Solution {
    int res = 0;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];
        //初始化边界条件
        //因为第一行/第一列的格子，只有一种走法，因此设置为1
        for(int i=0;i<rows&&obstacleGrid[i][0] == 0;i++)
            dp[i][0] = 1;
        for(int j=0;j<cols&&obstacleGrid[0][j] == 0;j++)
            dp[0][j] = 1;

        //状态转移方程
        for(int i=1;i<rows;i++)
            for(int j=1;j<cols;j++){
                if(obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        return dp[rows-1][cols-1];
    }

}
    






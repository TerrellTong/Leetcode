 /*
	算法思想：
	动态规划，此题与原来的max/min的动态规划不同.
	此题要求所有路径，可以等价于最多路径！！！！（转换思想）！！1
	在状态转移方程中，如果某些题要进行相应的转换才能往动态规划想，则状态转移方程没有max和min
 */
class Solution {
   public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    //矩阵的行的宽度
    int n = obstacleGrid.length;
    //矩阵的列的高度
    int m = obstacleGrid[0].length;
    //dp数组存的是路径的条数
    int[][] dp = new int[n][m];
    boolean iflag = false;
    boolean jflag = false;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (obstacleGrid[i][j] == 1) {
                dp[i][j] = 0;
                if (i == 0) iflag = true;
                if (j == 0) jflag = true;
            } else if (i == 0) {
                dp[i][j] = iflag ? 0 : 1;
            } else if (j == 0) {
                dp[i][j] = jflag ? 0 : 1;
            } else {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
    }
    return dp[n - 1][m - 1];
}
}


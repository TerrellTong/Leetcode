/*
	算法思想：
		dp

*/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1)
            return 0;
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if(row == 1 && col == 1)
            return obstacleGrid[0][0] == 0  1  0;
        int[][] dp = new int [row][col];

        base case
        
        for(int j=1;jcol;j++){
            if(obstacleGrid[0][j] == 1)
                dp[0][j] = 0;
            else if(j==1  dp[0][j-1] == 1)
                dp[0][j] = 1;
        }
        for(int i=1;irow;i++){
            if(obstacleGrid[i][0] == 1)
                dp[i][0] = 0;
            else if(i== 1  dp[i-1][0] == 1)
                dp[i][0] = 1;
        }


        for(int i=1;irow;i++)
            for(int j=1;jcol;j++){
                if(obstacleGrid[i][j] == 1)
                    continue;
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }

        return dp[row-1][col-1];
    }
}
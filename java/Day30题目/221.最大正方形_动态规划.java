/*
	算法思想：
		动态规划
*/
 
class Solution {
    public int maximalSquare(char[][] matrix) {
        //最大面积的边长
        int maxSide = 0;
        //如果marix为空，或者只有单边，则返回值为0
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return maxSide;
        int rows = matrix.length;
        int columns = matrix[0].length;
        //若某格子值为 1 ，则以此(i,j)为右下角的正方形的、最大边长为：上面的正方形、左面的正方形或左上的正方形中，最小的那个，再加上此格。
        int[][] dp = new int[rows][columns];
        for(int i=0;i < rows;i++)
            for(int j=0;j<columns;j++){
                if(matrix[i][j] == '1'){
                    //特殊值处理
                    if(i==0||j==0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;                       
                    }
                maxSide = Math.max(maxSide, dp[i][j]);  
                }
            }
        int maxSqare = maxSide * maxSide;
        return maxSqare;
    }
}

/*状态转换方程的推导
	见
	https://leetcode-cn.com/problems/count-square-submatrices-with-all-ones/solution/tong-ji-quan-wei-1-de-zheng-fang-xing-zi-ju-zhen-2/
*/













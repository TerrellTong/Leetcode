/*
	算法思想：
		深度优先遍历
				
*/

class Solution {
	//总的结果数
    int ans = 0;
	//每一片岛屿的最大值
    int current = 1;
    private int[] directX = {-1, 0, 1, 0};
    private int[] directY = {0, 1, 0, -1};
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        //找到一个岛屿，找到岛屿后标记为0，并且current初始化为1 
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    current = 1;
                    current = dfs(i,j,grid);
                    ans = Math.max(ans,current);
                }
            }
        return ans;
    }

    public int dfs(int curX,int curY,int[][] grid){
        for(int i=0 ;i<4;i++){
            //获取下一步
            int nextX = curX + directX[i];
            int nextY = curY + directY[i];
            //判断下一步是否满足条件，用gird数组的0来代表是否访问
            if(nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length && grid[nextX][nextY] == 1){
                //将已经访问的标志为0;
                grid[nextX][nextY] = 0;
                current++;
                dfs(nextX,nextY,grid);
            }
    }
    return current;
}
}













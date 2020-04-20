/*
	算法思想：
		深度优先遍历，没有想到怎么进行求res,其实在找到1就代表是一个岛屿了，要学会灵活变通！！！
*/


class Solution {
    //定义步骤
    int[] dx = new int[] {-1, 1, 0, 0};
    int[] dy = new int[] {0, 0, -1, 1};
    int res = 0;
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;

        visited = new boolean[row][col];
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++){
                //找到了1，说明这是一个岛屿
                if(grid[i][j] == '1' && ! visited[i][j]){
                    visited[i][j] = true;
                    res++;
                    dfs(i,j,grid);
                }
            }
        return res;
    }
    void dfs (int x ,int y,char[][] grid){
        for(int i=0;i<4;i++){
            int newX = x+dx[i];
            int newY = y+dy[i];
            //判断下一步
            if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && !visited[newX][newY] && grid[newX][newY] == '1') {
                visited[newX][newY] = true;
                dfs(newX,newY,grid);
            }
        }
    }
}













/*
	算法思想：
		查看每个岛屿可以贡献多少条边，如果周围都是岛屿，则贡献0条，反之如果没有岛屿则贡献4条，只有一个就是4-1 = 3
*/

class Solution {
    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    int lines = 4;
                    //判断这个岛旁边连接了多少个岛
                  	if(i > 0 && grid[i - 1][j] == 1) lines--;
                  	if(i < grid.length - 1 && grid[i + 1][j] == 1) lines--;
                  	if(j > 0 && grid[i][j - 1] == 1) lines--;
                  	if(j < grid[0].length - 1 && grid[i][j + 1] == 1) lines--;
                    sum += lines;          
                }
            }
        return sum;
    }
}
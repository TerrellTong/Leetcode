/*
	算法思想：
		先找到1，然后深搜。每找到一个1，则结果++
*/


class Solution {
    int res = 0;
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        //找到一个'1'，然后开始递归
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    res++;
                    visited[i][j] = true;
                    dfs(grid,i,j);            
                }
            }
        return res;
    }

    public void dfs(char[][] grid,int x,int y){

        //水平/竖直
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        for(int i=0;i<4;i++){
            int newx = x+dx[i];
            int newy = y+dy[i];
            if(newx >=0 && newy>=0 && newx<grid.length && newy<grid[0].length){
                //如果是1，而且没有被访问，则继续遍历
                if(!visited[newx][newy] && grid[newx][newy] == '1'){
                    visited[newx][newy] = true;
                    dfs(grid,newx,newy);
                }
            }
        }
    }
}
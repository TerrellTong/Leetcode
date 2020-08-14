/*
	算法思想：
		注意到题目解释中提到：任何边界上的 O 都不会被填充为 X。 我们可以想到，所有的不被包围的 O 都直接或间接与边界上的 O 相连。
		我们可以利用这个性质判断 O 是否在边界上
	
	dfs,我知道，但是对于如何改变O->X,不会，我是按照判断O的周围数目来解决的，但是解决不了！！！
	要通过间接转换！！！
		
代码：https://leetcode-cn.com/problems/surrounded-regions/solution/dfs-bfs-bing-cha-ji-by-powcai/
原理：https://leetcode-cn.com/problems/surrounded-regions/solution/bei-wei-rao-de-qu-yu-by-leetcode-solution/
*/

class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return;
        int row = board.length;
        int col = board[0].length;
        for(int j=0;j<col;j++){
            //第一行
            if(board[0][j] == 'O')
                dfs(board,0,j);
            //最后一行
            if(board[row-1][j] == 'O')
                dfs(board,row-1,j);
        }

        for(int i=0;i<row;i++){
            //第一列
            if(board[i][0] == 'O')
                dfs(board,i,0);
            //最后一列
            if(board[i][col-1] == 'O')
                dfs(board,i,col-1);
        }

        //转变
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++){
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'B') board[i][j] = 'O';
            }
    }

    public void dfs(char[][] board,int x, int y){
        //判断什么时候退出
        if(x < 0 || x >= board.length || y < 0 || y>= board[0].length || board[x][y] != 'O' )
                return;
        board[x][y] = 'B';
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        for(int i=0;i<4;i++){
            int new_x = x+dx[i];
            int new_y = y+dy[i];
            dfs(board,new_x,new_y);
        }
    }
}
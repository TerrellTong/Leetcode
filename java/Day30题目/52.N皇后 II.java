/*
	算法思想：
		与n皇后类似
		知道如何判断条件是否满足，但是对于dfs()进行深度搜索,还是不熟悉！！！
		

*/

class Solution {
    int res = 0;
    public int totalNQueens(int n) {
       char[][] board = new char[n][n];
       //棋盘初始化
       for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
            board[i][j] = '.';

        //从第一行开始放棋子;
        dfs(0,board);
        return res;
    }

    //判断该点是否可以进行落子
    public boolean put(int row,int col,char[][] board){
        //同一行是否存在皇后
        for(int j=0;j<col;j++){
            if(board[row][j] == 'Q')
                return false;
        }

        //同一列是否存在皇后
        for(int i=0;i<row;i++){
            if(board[i][col] == 'Q')
                return false;
        }

        //判断左对角线是否存在皇后
        for(int i=row,j = col;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q')
                return false;
        }

        //判断右对角先是否存在皇后
        for(int i=row,j = col;i>=0 && j<board[0].length;i--,j++){
            if(board[i][j] == 'Q')
                return false;
        }

        return true;
    }

    public void dfs(int start,char[][] board){
        if(start == board.length){
            res++;
            return;
        }

        //判断哪一列可以放置棋子
        for(int j=0;j<board[0].length;j++){
            if(put(start,j,board)){
                board[start][j] = 'Q';
                dfs(start+1,board);
                board[start][j] = '.';
            }
        }
    }
}


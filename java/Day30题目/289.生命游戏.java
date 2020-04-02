/*
	算法思想：

				
*/

//原地遍历
class Solution {
//mine  尝试改成原地
    //2表示活到死  -1表示死到活
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int lived=countCellular(i,j,board);
                //活细胞
                if(board[i][j]==1){
                    if(lived<2||lived>3){
                        board[i][j]=2;
                    }
                }else {//死细胞
                    if(lived==3){
                        board[i][j]=-1;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                  if(board[i][j]==-1){
                      board[i][j]=1;
                  }else if(board[i][j]==2){
                      board[i][j]=0;
                  }
            }
        }
    }
    int [][]next={
            {1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}
    };
    int countCellular(int x,int y,int[][]board){
        int count=0;
        for (int i = 0; i < next.length; i++) {
            int nextX=x+next[i][0];
            int nextY=y+next[i][1];
            if(nextX>=0&&nextY>=0&&nextX<board.length&&nextY<board[0].length){
                if(board[nextX][nextY]>0) 
                count++;
            }
        }
        return count;
    }
}

//用额外数组，可以满足“同时”的概念，如果只用一个数组进行，则不能满足“同时”的概念
class Solution {
   public void gameOfLife(int[][] board) {
        int [][]nextBoard=new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                nextBoard[i][j]=board[i][j];
                int lived=countCellular(i,j,board);
                //活细胞
                if(board[i][j]==1){
               if(lived<2||lived>3){
                   nextBoard[i][j]=0;
               }
                }else {//死细胞
                if(lived==3){
                    nextBoard[i][j]=1;
                }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j]=nextBoard[i][j];
            }
        }
    }
    int [][]next={
            {1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}
    };
   int countCellular(int x,int y,int[][]board){
       int count=0;
       for (int i = 0; i < next.length; i++) {
           int nextX=x+next[i][0];
           int nextY=y+next[i][1];
           if(nextX>=0&&nextY>=0&&nextX<board.length&&nextY<board[0].length){
               if(board[nextX][nextY]==1) count++;
           }
       }
       return count;
   }
}










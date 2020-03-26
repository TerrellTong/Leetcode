/*
	算法思想：
		简答的根据题目意思来

*/

class Solution {
    public int numRookCaptures(char[][] board) {
        //定义上下左右四个方向
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        //遍历整个棋盘
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                //找到白车的位置
                if(board[i][j] == 'R'){
                        int res = 0;
                        //试探上下左右的四个方向
                        for(int k=0;k<4;k++){
                            int x=i,y=j;
                            while(true){
                                x += dx[k];
                                y += dy[k];
                            if(x>=8||x<0||y>=8||y<0||board[x][y] == 'B')
                                break;
                            if(board[x][y] == 'p'){
                                res++;
                                break;
                            }
                        }
                        }
                        return res;
                }
            }
        }
        return -1;
    }
}

















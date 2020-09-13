/*
	算法思想：
		回溯
		
*/


class Solution {
    boolean flag = false;
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        //找到word的第一个字符,然后dfs
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++){
                if(board[i][j] == word.charAt(0))
                    dfs(i,j,row,col,word,visited,1,board);
                if(flag)
                    break;
            }

        return flag;
    }

    public void dfs(int x,int y,int row,int col,String word,boolean[][] visited,int index,char[][] board){
        if(index == word.length()){
            flag = true;
            return;
        }
        char c = word.charAt(index);
        visited[x][y] = true;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        for(int i=0;i<4;i++){
            int new_x = x+dx[i];
            int new_y = y+dy[i];
            if(new_x < 0 || new_x >= row || new_y < 0 || new_y >= col || visited[new_x][new_y] || board[new_x][new_y] != c)
                continue;
            dfs(new_x,new_y,row,col,word,visited,index+1,board);
            // visited[new_x][new_y] = false;
            if(flag)
                break;
        }
        //回溯，防止它被阻挡！ “C”“A”“A”，使得每一次找到x,y时相当于是新的棋盘！
        //主要解决 [["C","A","A"],["A","A","A"],["B","C","D"]]，找AAB
        //使得在主循环外时，是新的棋盘
        visited[x][y] = false;
    }
}
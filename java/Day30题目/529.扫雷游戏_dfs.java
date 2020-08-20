/*
	算法思想：
		深度优先遍历，先开始看了下想找答案的，一看是dfs,就尝试做了
		做出来了！！！
	
*/


class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        //点击下的坐标
        int x = click[0];
        int y = click[1];
        //visited用于存，该点是否被访问
        boolean[][] visited = new boolean[board.length][board[0].length];
        //如果访问的点当前是地雷，则改成X，并直接返回
        if(board[x][y] == 'M'){
            board[x][y] = 'X';
            return board;
        }

        //进行dfs遍历
        dfs(board,x,y,visited);
        return board;
    }

    //使用深度优先搜索进行遍历
    public void dfs(char[][] board,int x,int y,boolean[][] visited){
        //如果递归的条件不满足，则直接返回
        if(board[x][y] != 'E')
            return ;
        
        visited[x][y] = true;

        // //如果当前是地雷，则改成X，并直接返回
        // if(board[x][y] == 'M'){
        //     board[x][y] = 'X';
        //     return ;
        // }

        if(board[x][y] == 'E'){
            //记录周围地雷的数量
            int count = 0;
            //判断四周地雷的数量
            int[] dx = {-1,0,1};
            int[] dy = {-1,0,1};
            for(int i=0;i<3;i++)
                for(int j=0;j<3;j++){
                    int new_x = x+dx[i];
                    int new_y = y+dy[j];
                    //如果当前位置已经访问或者新的位置不满足board条件则直接返回
                    if(new_x < 0 || new_x>= board.length || new_y < 0 || new_y >= board[0].length || visited[new_x][new_y])
                        continue;
                    if(board[new_x][new_y] == 'M')
                        count++;
                }
            //如果当前周围没有地雷
            if(count == 0){
                board[x][y] = 'B';
                for(int i=0;i<3;i++)
                    for(int j=0;j<3;j++){
                        int new_x = x+dx[i];
                        int new_y = y+dy[j];
                        //如果当前位置已经访问或者新的位置不满足board条件则直接返回
                        if(new_x < 0 || new_x>= board.length || new_y < 0 || new_y >= board[0].length || visited[new_x][new_y])
                            continue;
                        dfs(board,new_x,new_y,visited);
                }
            }else{
                board[x][y] = (char)(count+'0');
                return;
            }

        }


    }
}
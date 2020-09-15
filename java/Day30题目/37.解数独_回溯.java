/*
	算法思想：
		回溯，思想知道，不知道怎么解决问题
		尤其是规则3，题干条件的转化。
		采用三个boolean数组，用来表示规则1,2,3是否满足！
		
*/


class Solution {
    boolean[][] row = new boolean[9][9];
    boolean[][] column = new boolean[9][9];
    //用block记录，每个3*3的宫中，粗实线分割的数字1-9只出现一次
    //相当于每个3*3的宫中，同一位置9个子3*3的同一位置，不能出现相同的数字
    boolean[][][] block = new boolean[3][3][9];
    boolean valid = false;
    List<int[]> spaces = new ArrayList();


    public void solveSudoku(char[][] board) {
        //将整个数独的‘.’，进行存储
        //发现数字后，将i,j和digit分别标注，从而满足规则1,2,3
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++){
                if(board[i][j] == '.')
                    spaces.add(new int[]{i,j});
                else{
                    int digit = board[i][j] - '0'-1;
                    row[i][digit] = column[j][digit] = block[i/3][j/3][digit] = true;
                }
            }
        
        dfs(board,0);
    }

    public void dfs(char[][] board,int pos){
        //如果pos与space相等，说明“.”已经全部找到了
        if(pos == spaces.size()){
            valid = true;
            return;
        }

        int[] space = spaces.get(pos);
        int i = space[0],j = space[1];
        for(int digit = 0;digit<9 && !valid;digit++){
            //如果条件满足，说明此时的这个数字，满足上面的三个规则
            if(!row[i][digit] && !column[j][digit] && !block[i/3][j/3][digit]){
                row[i][digit] = column[j][digit] = block[i/3][j/3][digit] = true;
                board[i][j] = (char)(digit + '0' + 1);
                dfs(board,pos+1);
                row[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }
    }
}
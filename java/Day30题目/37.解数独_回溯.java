/*
	算法思想：
		回溯思想，学会对规则3）的转换
		valid的作用？为什么在回溯的时候不要"."？可以见代码中的注释！
		
*/


class Solution {
    //表示哪一行的某个数字是否被标记
    boolean[][] rowflag = new boolean[9][9];
    //表示哪一列的某个数字是否被标记
    boolean[][] colflag = new boolean[9][9];
    //表示棋盘3*3的位置只能出现一次，相当于规则（3）的转换
    boolean[][][] squareflag = new boolean[3][3][9];
    //存储空格的位置
    List<int[]> dots = new ArrayList();

    //当程序找到正确结果后就直接返回，不然会一直回溯的！！
    boolean valid = false;

    public void solveSudoku(char[][] board) {
        //遍历整个棋盘，找到所有的"."和数字，并标记

        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++){
                if(board[i][j] == '.'){
                    dots.add(new int[]{i,j});
                }else{
                    //由于数组是0-8的，因此要减一
                    int digit = board[i][j] - '0' -1;
                    rowflag[i][digit] = colflag[j][digit] = squareflag[i/3][j/3][digit] = true;
                }
            }
        dfs(board,0);
    }

    public void dfs(char[][] board,int pos){
        if(pos == dots.size()){
            valid = true;
            return;
        }

        int[] res = dots.get(pos);
        //空白格子的位置
        int x = res[0];
        int y = res[1];
        for(int digit = 0;digit<9 && !valid ;digit++){
            if(!rowflag[x][digit] && !colflag[y][digit] && !squareflag[x/3][y/3][digit]){
                //此时的digit不是真正要填入棋盘的值，而是应该让当前值+1
                board[x][y] = (char)(digit + '0' + 1);
                rowflag[x][digit] = colflag[y][digit] = squareflag[x/3][y/3][digit] = true;
                dfs(board,pos+1);
                rowflag[x][digit] = colflag[y][digit] = squareflag[x/3][y/3][digit] = false;
                //因为一定会找到一个满足条件的值去覆盖掉不满足条件的值，所以没有必要恢复到 '.'
                //spaces数组记录空白位置，pos在迭代的过程中返回上层时会-1，表示数组已经认为这个位置可填写。迭代的标准是spaces是否遍历完而非board是否全填满
            }
        }

    }
}
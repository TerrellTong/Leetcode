/*
	算法思想：
		简单题，直接模拟即可！
		
*/


class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int col = A[0].length;
        int row = A.length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col/2;j++){
                int tmp = A[i][j];
                A[i][j] = A[i][col-j-1];
                A[i][col-j-1] = tmp;
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                A[i][j] = A[i][j] == 1 ? 0 : 1;
            }
        }
        return A;
    }
}
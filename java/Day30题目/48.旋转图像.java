/*
	算法思想：
		之前做过，相当于二刷，但是不是按照标答的思想，我是沿主对角线对折+然后沿着中点对折
*/

class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        //沿着主对角线对折
        for(int i=0;i<row;i++){
            for(int j=i;j<col;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        //对折后再次沿着中点对折
        for(int i=0;i<row;i++){
            for(int j=0;j<(col+1)/2;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][col-j-1];
                matrix[i][col-j-1] = tmp;
            }
        }
    }
}
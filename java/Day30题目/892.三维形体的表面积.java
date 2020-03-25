/*
	算法思想：
		画图找规律

*/

class Solution {
    public int surfaceArea(int[][] grid) {

        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }

        int cols = grid[0].length;
        if (cols == 0) {
            return 0;
        }

        // 总的单位立方体的个数
        int sum = 0;
        // 垂直重叠
        int verticalOverlap = 0;
        // 行重叠
        int rowOverlap = 0;
        // 列重叠
        int colOverlap = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += grid[i][j];

                if (grid[i][j] > 0) {
                    verticalOverlap += (grid[i][j] - 1);
                }

                if (j > 0) {
                    rowOverlap += Math.min(grid[i][j - 1], grid[i][j]);
                }

                if (i > 0) {
                    colOverlap += Math.min(grid[i - 1][j], grid[i][j]);
                }
            }
        }
        return sum * 6 - (verticalOverlap + rowOverlap + colOverlap) * 2;
    }
}

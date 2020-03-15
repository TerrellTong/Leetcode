 /*
	算法思想：
	深度优先遍历，也可以求最值
 */
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //计算最大面积
                int currMaxArea = getMaxArea(i, j, grid);
                maxArea = Math.max(currMaxArea, maxArea);
            }
        }
        return maxArea;
    }
    
    private int getMaxArea(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        //通过将经过的岛屿设置为0来确保下次不会重复访问
        grid[i][j] = 0;

        int upMaxArea = getMaxArea(i - 1, j, grid);

        int downMaxArea = getMaxArea(i + 1, j, grid);

        int leftMaxArea = getMaxArea(i, j - 1, grid);

        int rightMaxArea = getMaxArea(i, j + 1, grid);

        return upMaxArea + downMaxArea + leftMaxArea + rightMaxArea + 1;
    }
}


/*
	算法思想：
		深度优先遍历，没有想到怎么进行求res,其实在找到1就代表是一个岛屿了，要学会灵活变通！！！
*/


class Solution {
    //定义步骤
    int[] dx = new int[] {-1, 1, 0, 0};
    int[] dy = new int[] {0, 0, -1, 1};
    int res = 0;
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;

        visited = new boolean[row][col];
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++){
                //找到了1，说明这是一个岛屿
                if(grid[i][j] == '1' && ! visited[i][j]){
                    visited[i][j] = true;
                    res++;
                    dfs(i,j,grid);
                }
            }
        return res;
    }
    void dfs (int x ,int y,char[][] grid){
        for(int i=0;i<4;i++){
            int newX = x+dx[i];
            int newY = y+dy[i];
            //判断下一步
            if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && !visited[newX][newY] && grid[newX][newY] == '1') {
                visited[newX][newY] = true;
                dfs(newX,newY,grid);
            }
        }
    }
}


//广度优先遍历
//找到了一个1之后而且未被访问，说明这是一个岛屿，然后对这个找到的1进行广度优先遍历（直到队列为空就退出循环，说明与第一个1相关的岛屿全部进行遍历完成了）

public class Solution2 {


    private int rows;
    private int cols;

    public int numIslands(char[][] grid) {
        //           x-1,y
        //  x,y-1    x,y      x,y+1
        //           x+1,y
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        cols = grid[0].length;
        boolean[][] marked = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 如果是岛屿中的一个点，并且没有被访问过
                // 从坐标为 (i,j) 的点开始进行广度优先遍历
                if (!marked[i][j] && grid[i][j] == '1') {
                    count++;
                    LinkedList<Integer> queue = new LinkedList<>();
                    // 小技巧：把坐标转换为一个数字
                    // 否则，得用一个数组存，在 Python 中，可以使用 tuple 存
                    queue.addLast(i * cols + j);
                    // 注意：这里要标记上已经访问过
                    marked[i][j] = true;
                    while (!queue.isEmpty()) {
                        int cur = queue.removeFirst();
                        int curX = cur / cols;
                        int curY = cur % cols;
                        // 得到 4 个方向的坐标
                        for (int k = 0; k < 4; k++) {
                            int newX = curX + directions[k][0];
                            int newY = curY + directions[k][1];
                            // 如果不越界、没有被访问过、并且还要是陆地，我就继续放入队列，放入队列的同时，要记得标记已经访问过
                            if (inArea(newX, newY) && grid[newX][newY] == '1' && !marked[newX][newY]) {
                                queue.addLast(newX * cols + newY);
                                // 【特别注意】在放入队列以后，要马上标记成已经访问过，语义也是十分清楚的：反正只要进入了队列，你迟早都会遍历到它
                                // 而不是在出队列的时候再标记
                                // 【特别注意】如果是出队列的时候再标记，会造成很多重复的结点进入队列，造成重复的操作，这句话如果你没有写对地方，代码会严重超时的
                                marked[newX][newY] = true;
                            }
                        }
                    }
                }
            }

        }
        return count;
    }

    private boolean inArea(int x, int y) {
        // 等于号这些细节不要忘了
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}


作者：liweiwei1419
链接：https://leetcode-cn.com/problems/number-of-islands/solution/dfs-bfs-bing-cha-ji-python-dai-ma-java-dai-ma-by-l/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。













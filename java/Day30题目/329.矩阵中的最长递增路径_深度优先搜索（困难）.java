/*
	算法思想：
		深度优先遍历

	只需要让下一步的点 > 当前点的值，则进行下一步递归

https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/solution/ju-zhen-zhong-de-zui-chang-di-zeng-lu-jing-by-le-2/
*/

class Solution {
    //路径步骤
    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int rows,cols;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0)
            return 0;
        rows = matrix.length;
        cols = matrix[0].length;
        //声明visited数组的作用:能够判断是否访问了以及记录最长的递增路径
        int[][] visited = new int[rows][cols];
        //记录最长的递增路径长度
        int max = 0;
        //对每一个单元格都要分别进行深度优先搜索
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                //如果当前数组未被遍历，则进行递归
                if(visited[i][j] == 0)
                    max = Math.max(max,dfs(i,j,matrix,visited));
        return max;
    }

    public int dfs(int i,int j,int[][] matrix,int[][] visited){
        //进行记忆化
        if(visited[i][j] > 0)
            return visited[i][j];
        //如果进行了dfs，说明此时visit[i][j]的值++，说明此时路径++
        visited[i][j]++;
        for(int[] dir:dirs){
            int newRow = i + dir[0], newColumn = j + dir[1];
            //只需要下一步点的值，> 当前点的值，则进行下一步操作
            if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < cols && matrix[newRow][newColumn] > matrix[i][j])
				//dfs(newRow, newColumn,matrix, visited) + 1 表明当前所代表的数组，路径长度+1
                visited[i][j] = Math.max(visited[i][j], dfs(newRow, newColumn,matrix, visited) + 1);
        }
        return visited[i][j];
    }
}
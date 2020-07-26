/*
	算法思想：
		深度优先遍历

	不是一个普通的dfs，因为要找到当前的递增路径，因此在判断的时候，以此为这个点为基础，找到四周是否存在比当前小的点，如果存在则进行以此点为基础进行深度优先搜索
	这样存在的一个路径一定是一个递增/递减的， 但是递减从反方向看也是递增的！
	相当于找一个递减路径！

https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/solution/javashi-xian-shen-du-you-xian-chao-ji-jian-dan-yi-/
*/

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0)
            return 0;
        //声明visited数组，两个作用：判断是否访问过，存储当前格子的最长递增长度
        int[][] visited = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++){
                if(visited[i][j] == 0)
                    max = Math.max(max,dfs(i,j,matrix,visited));
            }
        return max;
    }

    public int dfs(int i,int j,int[][] matrix,int[][] visited){
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length)
            return 0;
        //进行记忆化
        if(visited[i][j] > 0)
            return visited[i][j];
        int max = 0;
        //去判断四周是否比当前数小，然后进行递归遍历
        if(i-1 >= 0 && matrix[i-1][j] < matrix[i][j])
            max = Math.max(max,dfs(i-1,j,matrix,visited));
        if(i+1 < matrix.length && matrix[i+1][j] < matrix[i][j])
            max = Math.max(max,dfs(i+1,j,matrix,visited));
        if(j-1 >= 0 && matrix[i][j-1] < matrix[i][j])
            max = Math.max(max,dfs(i,j-1,matrix,visited));
        if(j+1 < matrix[0].length && matrix[i][j+1] < matrix[i][j])
            max = Math.max(max,dfs(i,j+1,matrix,visited));
        
        visited[i][j] = max+1;
        return max+1;
    }
}
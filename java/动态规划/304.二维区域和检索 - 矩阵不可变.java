/*
	算法思想：
		与一维类似，没想到！！
		存储每一行中，每一行的每一列的各个位置的前缀和
		
https://leetcode-cn.com/problems/range-sum-query-2d-immutable/solution/er-wei-qu-yu-he-jian-suo-ju-zhen-bu-ke-bian-by-lee/
		
*/

class NumMatrix {
    int[][] nums;
    public NumMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return;
        nums = new int[matrix.length][matrix[0].length+1];
        //记录每一行中，每个位置的前缀和
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++)
                nums[i][j+1] = nums[i][j] + matrix[i][j];
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i=row1;i<=row2;i++)
            sum += nums[i][col2+1] - nums[i][col1];
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
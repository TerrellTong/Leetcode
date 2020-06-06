/*
	算法思想：
		模拟算法思想，记得书写规范
	
*/
 
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return new int[0];
        }
        int col = matrix[0].length;
        int[] res = new int[row * col];
        int left = 0,top = 0,right = col-1,bottom = row-1;
        //用于存储数组的下标
        int idx = 0;
        while(true){
            //从左向右遍历

            for(int i=left;i<=right;i++)
                res[idx++] = matrix[top][i];

            //从上往下遍历
            if(++top > bottom)
                break;
            for(int i = top;i<=bottom;i++)
                res[idx++] = matrix[i][right];

            //从右往左遍历
            if(--right < left)
                break;
            for(int i=right;i>=left;i--)
                res[idx++] = matrix[bottom][i];

            //从下往上遍历               
            if(--bottom < top)
                break;
            for(int i=bottom;i>=top;i--)
                res[idx++] = matrix[i][left];
			
			//必须写在这里，不然会出问题
			if(++left > right)
                break;
        }
        return res;
    }
}










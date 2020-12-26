/*
	算法思想：
		已经做了N次了，还是不会！！！
		模拟进行过程，在一个死循环中，每遍历一次就将边界进行缩小
*/

class Solution {
    public ListInteger spiralOrder(int[][] matrix) {
        int top = 0;
        int down = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        ListInteger res = new ArrayList();
        while(true){
            
            for(int i=left;i=right;i++){
                res.add(matrix[left][i]);
            }
            if(++top  down)
                break;

            for(int i=top;i=down;i++)
                res.add(matrix[i][right]);
            if(--right  left)
                break;

            for(int i=right;i=left;i--)
                res.add(matrix[down][i]);
            if(--down  top)
                break;

            for(int i=down;i=top;i--){
                res.add(matrix[i][left]);
            }
            if(++left  right)
                break;
            
        }
        return res;
    }
}
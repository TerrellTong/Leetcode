/*
	算法思想：
		模拟，记住，旋转一圈后，左边的起始点，x,y都加1 ，右下角的终点都-1
		思路知道要模拟，不知道怎么实现，好像之前做过，还是不会做！！！
		
参考思路：https://leetcode-cn.com/problems/spiral-matrix/solution/si-lu-qing-xi-ji-bai-liao-98de-javayong-hu-by-reed/
*/


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList();
        if (matrix == null || matrix.length == 0) {
            return list;
        }

        int startx = 0;
        int starty = 0;
        int endx = matrix.length-1;
        int endy = matrix[0].length-1;
        while(startx < endx && starty < endy){
                //最上面的边界
                for(int i=starty;i<endy;i++)
                    list.add(matrix[startx][i]);
                
                //最右边的边界
                for(int i=startx;i<endx;i++)
                    list.add(matrix[i][endy]);

                //最下面的边界
                for(int i=endy;i>starty;i--)
                    list.add(matrix[endx][i]);

                //最左边的边界
                for(int i=endx;i>startx;i--)
                    list.add(matrix[i][starty]);

                startx++;
                endx--;
                starty++;
                endy--;
        }

        //只有一行时
        if(starty == endy){
            while(startx <= endx)
                list.add(matrix[startx++][starty]);
        }else if(startx == endx){
            while(starty <= endy)
                list.add(matrix[startx][starty++]);
        }
        return list;
        
    }
}
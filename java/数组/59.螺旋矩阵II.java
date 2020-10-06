/*
	算法思想：
		按照螺旋矩阵I的思路完成！
*/


class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int startx = 0;
        int starty = 0;
        int endx = n-1;
        int endy = n-1;
        int startN = 1;

        while(startx < endx && starty < endy){
            for(int i=starty;i<endy;i++){
                res[startx][i] = startN;
                startN++;
            }

            for(int i=startx;i<endx;i++){
                res[i][endx] = startN;
                startN++;
            }

            for(int i=endy;i>starty;i--){
                res[endx][i] = startN;
                startN++;
            }

            for(int i=endx;i>startx;i--){
                res[i][starty] = startN;
                startN++;
            }

            startx++;
            starty++;
            endx--;
            endy--;

        }

        if(startx == endx){
            while(starty <= endy){
                res[startx][starty] = startN;
                startN++;
                starty++;
            }
        }

        if(starty == endy){
            while(startx <= endx){
                res[startx][starty] = startN;
                startN++;
                startx++;
            }
        }

        return res;
    }
}
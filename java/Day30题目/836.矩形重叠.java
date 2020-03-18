 /*
	算法思想：
	检查区域
	一维情况：
		（x1,x2）(y1,y2），如果相交，相交部分的左端点一定是两个线段左端点取大，相交部分的右端点是两个线段的后端点取小。
		那就先算出这两个值，然后再比一下相交部分的左端点是否小于右端点。
	二维情况：
		将二维投影到x,y轴中，进行与一维相同的判断
 */
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
           return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) &&
                Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));
    }
}








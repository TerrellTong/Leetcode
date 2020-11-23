/*
	算法思想：
		贪心算法
		我们应该射出一支箭，使其能够引爆更多的气球，
		左端排序，两两比较，当前区间左端比前一个右端小就继续，否则箭数加一
		这样的二维数组，记得排序
		
		怎么说呢？
		想到了要排序，但是没继续下去，被贪心算法吓到了！！
		还有之前做动态规划做多了，以为是动态规划，想着暴力，求选择某个数字后，然后进行戳，判断这个数字能戳中的最大数目！
		
	
题解：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/solution/yong-zui-shao-shu-liang-de-jian-yin-bao-qi-qiu-1-2/	
*/

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points,new Comparator<int[]>(){
            @Override
            public int compare(int[] point1,int[] point2){
                //由于存在溢出的情况，因此像下面进行排序，不能用 ‘-’ 比较
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        
        int pos = points[0][1];
        int ans = 1;
        for(int[] ballon : points){
            if(ballon[0] > pos){
                pos = ballon[1];
                ans++;
            }
        }
        return ans;
    }
}
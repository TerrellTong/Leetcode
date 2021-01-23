/*
	算法思想：
		labuladong,按照右区间进行排序，本题也相当于是找最多有多少个互不重叠的区间！
		

*/

class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0)
            return 0;

        List<int[]> res = new ArrayList();
        int count = 1;
        //右端点进行排序
        Arrays.sort(points,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return a[1]-b[1];
            }
        });

        int start = points[0][0];
        int end = points[0][1];

        for(int i=1;i<points.length;i++){
            int curx = points[i][0];
            if(curx > end){
                count++;
                end = points[i][1];
            }
        }
        return count;
    }
}
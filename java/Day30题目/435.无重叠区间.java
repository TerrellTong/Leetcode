/*
	算法思想：
		没有太弄清楚到底怎么做，尝试了一下，还是有问题！！
		
		解题思路：常规的区间问题一般都是通过这样的思路进行解决，就是先根据起点进行排序，然后用一个指针获取前一个区间，用于比较，再遍历数组，。

				如果遇到覆盖，就肯定需要删除一个区间，同时更新指针，因为需要尽可能不会与后面的区间再产生重叠，所以需要保留区间小的；
				如果没有覆盖，那么将指针更新为当前区间。
				
				先讨论没有覆盖的情况，再讨论覆盖的情况！！

作者：lippon
链接：https://leetcode-cn.com/problems/non-overlapping-intervals/solution/java-chang-gui-de-qu-jian-wen-ti-jie-jue-qdxv/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/


class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });
        if(intervals.length == 0)
            return 0;
        int left = intervals[0][0];
        int right = intervals[0][1];
        int count = 0;

        for(int i=1;i<intervals.length;i++){
            int curLeft = intervals[i][0];
            int curRight = intervals[i][1];
            //没有重叠
            if(curLeft >= right){
                left = curLeft;
                right = curRight;
            }else if(curRight <= left){
                left = curLeft;
                right = curRight;
            } else{
                //如果当前区间大于上一个区间的右边，则count++，存在重叠
                count++;
                //右边进行更新,保留长度小的区间，这样就尽可能不会与后面的区间再次重叠
                right = Math.min(curRight,right);
            }
        }
        return count;
    }
}
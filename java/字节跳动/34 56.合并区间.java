/*
	算法思想：
		用res存储，每次比较，取res的值的左右区间即可
		之前做过，跟合并区间弄混了！！！（没做出来！！）
		
		常规的区间问题一般都是通过这样的思路进行解决，就是先根据起点进行排序，然后用一个指针获取前一个区间，用于比较，再遍历数组，。然后处理重叠的情况！！
		
题解：https://leetcode-cn.com/problems/merge-intervals/solution/tan-xin-suan-fa-java-by-liweiwei1419-3/
*/


class Solution {
    public int[][] merge(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        int len = intervals.length;
        List<int[]> res = new ArrayList();
        res.add(intervals[0]);


        //找到第一个不满足条件的值
        for(int i = 1;i < len;i++){
            //获取当前区间的值，即左区间和右区间
            int[] curInterval = intervals[i];

            //观看res集合的最后一个数组
            int[] peek = res.get(res.size()-1);

            //当前左区间，大于结果的右区间，因此不需要合并
            if(curInterval[0] > peek[1])
                res.add(curInterval);
            else
                //如果左区间小于右区间，可以合并，右边取两者的最大
                peek[1] = Math.max(curInterval[1],peek[1]);
        }
		//将res转成二维数组！
        return res.toArray(new int[res.size()][]);
    }
}

//按照新的思路做的
class Solution {
    public int[][] merge(int[][] intervals) {
        //排序
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                //按照从最左边排序
                return a[0]-b[0];
            }
        });
        //将intervals[0]，放入List中（list存储的就是合并区间后的结果）
        List<int[]> res = new ArrayList();
         //left，right为待插入的区间左右值
        int left = intervals[0][0];
        int right = intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            //获取当前区间的值
            int curLeft = intervals[i][0];
            int curRight = intervals[i][1];

            //如果当前left大于上一个最右边，将上一个区间加入res
            if(curLeft > right){
                res.add(new int[]{left,right});
                left = curLeft;
                right = curRight;
            }else if(curRight < left){
                //此时当前left大于于list的最右边，可以合并
                res.add(new int[]{left,right});
                left = curLeft;
                right = curRight;
            }else{
                // 此时存在重合
                left = Math.min(left,curLeft);
                right = Math.max(right,curRight);
            }
        }
        res.add(new int[]{left,right});
        return res.toArray(new int[0][]);
    }
}

//二刷发现了新问题，添加时出了问题，记住，left，right为上一个区间的左右值！！
class Solution {
    public int[][] merge(int[][] intervals) {
        //排序
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                //按照从最左边排序
                return a[0]-b[0];
            }
        });

        int left = intervals[0][0];
        int right = intervals[0][1];

        List<int[]> list = new ArrayList();
        // boolean placed = true;

        for(int i=1;i<intervals.length;i++){
            int curLeft = intervals[i][0];
            int curRight = intervals[i][1];

            //判断不是重叠的时候
            if(curLeft > right || curRight < left){
                //不重叠，我们要叠加上一个区间，不是当前区间！！
                list.add(new int[]{left,right});
                //将上一个区间的curLeft置为left，curRight置为right
                left = curLeft;
                right = curRight;
            }else{
                //出现重叠
                left = Math.min(left,curLeft);
                right = Math.max(right,curRight);
            }
        }

        list.add(new int[]{left,right});
        return list.toArray(new int[0][]);
    }
}
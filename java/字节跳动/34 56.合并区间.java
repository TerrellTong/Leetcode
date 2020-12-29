/*
	算法思想：
		用res存储，每次比较，取res的值的左右区间即可
		之前做过，跟合并区间弄混了！！！（没做出来！！）
		
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
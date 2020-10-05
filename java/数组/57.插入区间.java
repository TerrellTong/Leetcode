/*
	算法思想：
		按照普通的思路，被hard吓到了！！
		如果插入的左端点大于intervals的右端点，直接放入list
		如果插入的右端点大于intervals的左端点，进行去重比较，更改tmp
		
思路：https://leetcode-cn.com/problems/insert-interval/solution/chang-gui-si-kao-by-powcai/
*/


class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList();
        int i = 0;

        //当插入的左端点与区间的右端点还大，说明该区间没有满足条件的，可以遍历下一个
        while(i < intervals.length && newInterval[0] > intervals[i][1]){
            res.add(intervals[i]);
            i++;
        }

        int[] tmp = new int[]{newInterval[0],newInterval[1]};

        //当插入的右端点大于等于区间的左端点，说明存在重合部分
        //然后比较出tmp[0],tmp[1]应该如何修改
        while(i < intervals.length && newInterval[1] >= intervals[i][0]){
            tmp[0] = Math.min(tmp[0],intervals[i][0]);
            tmp[1] = Math.max(tmp[1],intervals[i][1]);
            i++;
        }
        res.add(tmp);
		//如果还剩没有比较的，直接放入res
        while(i<intervals.length){
            res.add(intervals[i]);
            i++;
        }

        //toArray(),带参数表明转换到自己想要的数组集合
        return res.toArray(new int[0][]);
    }
}
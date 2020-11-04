/*
	算法思想：
		思路大致知道，但是重合部分要用tmp没有想到，不扎实！！相当于二刷！！
		我用的for,但是一次遍历中，要分情况讨论不同的逻辑，需要讨论的太复杂，可以直接分段使用while！！！

题解：https://leetcode-cn.com/problems/insert-interval/solution/shou-hua-tu-jie-57-cha-ru-qu-jian-fen-cheng-3ge-ji/

*/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList();


        int index = 0;

        //在一次遍历中，要分情况讨论不同的逻辑，因此不能采用for循环

        //如果要插入的左端点大于当前区间的右端点，则将其加入list列表中
        //采用while循环，不采用for循环
        while(index < intervals.length && newInterval[0] > intervals[index][1]){
            list.add(new int[]{intervals[index][0],intervals[index][1]});
            index++;
        }

        int[] tmp = new int[]{newInterval[0],newInterval[1]};
        
        //此时的右端点大于当前区间的左端点，说明可以插入进去
        while(index < intervals.length && newInterval[1] >= intervals[index][0]){
            tmp[0] = Math.min(intervals[index][0],tmp[0]);
            tmp[1] = Math.max(intervals[index][1],tmp[1]);
            index++;
        }
        //此时已经成功扩增区间
        list.add(tmp);

        while(index < intervals.length){
            list.add(new int[]{intervals[index][0],intervals[index][1]});
            index++;
        }

        return list.toArray(new int[0][]);
    }
}
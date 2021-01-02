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


//按照自己的思路，模仿答案，完成了昨天自己的思路
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList();
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed =false; //标志新增区间插入到结果中
        for(int i=0;i<intervals.length;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            //如果要插入的左端点大于当前区间的右端点，则将其加入list列表中
            if(intervals[i][0] > right){
				//如果没有把变换后的结果加入区间，说明可以加入区间
                if(!placed){
                    list.add(new int[]{left,right});
                    placed = true;
                }
				//加入当前区间
                list.add(new int[]{start,end});
            }
            //此时的右端点小于当前区间的左端点，说明不能插入
            else if(intervals[i][1] < left){
                list.add(new int[]{start,end});
            }else{
                //说明插入区间有交集
                left = Math.min(left,start);
                right = Math.max(right,end);
            }
        }

        if(!placed)
            list.add(new int[]{left,right});
        return list.toArray(new int[0][]);
    }
}

//新的心得体会
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int []b){
                return a[0] - b[0];
            }
        });
        List<int[]> res = new ArrayList();
        
        //left，right为待插入的区间左右值
        int left = newInterval[0];
        int right = newInterval[1];
          boolean placed =false; //标志新增区间插入到结果中

        for(int i=0;i<intervals.length;i++){
            //获取当前区间的值
            int curLeft = intervals[i][0];
            int curRight = intervals[i][1];
            //独立
            if(curLeft > right){
                //如果没有把变换后的结果加入区间，说明可以加入区间，只有当curLeft>right才能将区间插入！！
                if(!placed){
                    res.add(new int[]{left,right});
                    placed = true;
                }
                res.add(intervals[i]);
            }else if(curRight < left){
				//如果将两个写到一起（即当前右边 < left,也会添加到res），就会[3,5]没有被插入的情况！！
				/*
					[[1,2],[3,5],[6,7],[8,10],[12,16]]
					[4,8]
					这样的情况！！！ 
				*/
                res.add(intervals[i]);
            }else{
                //有交集
                left = Math.min(left,curLeft);
                right = Math.max(right,curRight);
            }
        }
        //如果没有把变换后的结果加入区间，说明可以加入区间
                if(!placed){
                    res.add(new int[]{left,right});
                    placed = true;
                }
        return res.toArray(new int[0][]);
    }
}
 /*
	算法思想：
	滑动窗口，

 */
class Solution {
    public int[][] findContinuousSequence(int target) {
        //左窗口的边界
        int i=1;
        //右窗口的边界
        int j=1;
        //总和
        int sum = 0;
        //记录满足条件的数组
        List<int []> res_list = new ArrayList();
        while(i < target/2){                             //如果i=target/2 那么i+1,就i+i+1 > target，那么就不用数了，题干为至少两个数
            if(sum < target){
                //窗口右边界右移
                sum = sum + j;
                j++;
            }
            if(sum > target){
                //左边界右移
                sum = sum - i;
                i++;
            }
            if(sum == target){
                int[] res =  new int [j-i];
                //遍历存值
                for(int k=i;k<j;k++){
                    res[k-i] = k;
                }
                res_list.add(res);
                //满足条件后，左边界右移继续找下一组
                sum = sum - i;
                i++;
            }
        }
        return res_list.toArray(new int[res_list.size()][]);
    }
}

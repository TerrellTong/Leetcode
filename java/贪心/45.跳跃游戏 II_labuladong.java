/*
	算法思想：
		labuladong,与1的思维类似，都要计算最长距离，只是这题是当我们走到了最远位置时再step++!
		

*/


class Solution {
    public int jump(int[] nums) {
        int step = 0;
        int maxpos = 0;
        int end = 0;
        for(int i=0;i<nums.length-1;i++){
            //找到最远位置
            maxpos = Math.max(maxpos,nums[i]+i);
            if( i == end){
                end = maxpos;
                step++;
            }
        }
        return step;
    }
}
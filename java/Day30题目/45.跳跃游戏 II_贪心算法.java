/*
	算法思想：
		贪心算法，每次都要找maxpos，当i == end ，就把maxpos赋给end,此时step++;
*/
 
class Solution {
    public int jump(int[] nums) {
        int step = 0;
        int end = 0;
        int maxpos = 0;
        //在遍历数组时，我们不访问最后一个元素，这是因为在访问最后一个元素之前，
		//我们的边界一定大于等于最后一个位置，否则就无法跳到最后一个位置了。
		//如果访问最后一个元素，在边界正好为最后一个位置的情况下，我们会增加一次「不必要的跳跃次数」，因此我们不必访问最后一个元素。
        for(int i=0;i<nums.length-1;i++){
            //找到maxpos
            maxpos = Math.max(maxpos,nums[i]+i);
            //如果i==end,则用maxpos更新end
            if( i==end){
                end = maxpos;
                step++;
            }
        }
        return step;
    }
}













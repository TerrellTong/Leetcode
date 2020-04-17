/*
	算法思想：
	 贪心算法
*/


class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1)
            return true;
        int max = 0;
        //阶梯的长度
        int len = nums.length-1;
        //从阶梯0开始遍历
        for(int i = 0; i<nums.length;i++ ){
			//如果当前值可跳跃步数为0，并且可到达的最大值小于/等于当前阶数则返回false
            if(nums[i] == 0 && ! (max > i))
                return false;
            max = Math.max(max,i+nums[i]);
            if(max > len || max == len)
                return true;
        }
        return false;
    }
}













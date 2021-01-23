/*
	算法思想：
		labuladong,每次都记录能跳的最大位置farthest，如果farthest<=当前的i，则返回false！否则判断farthest是否>=n-1
		

*/


class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for(int i=0;i<n-1;i++){
            //不断的计算能跳到的最大位置
            farthest = Math.max(farthest,i+nums[i]);
            if(farthest <= i)
                return false;
        }
		return farthest >= n-1;
	}
}
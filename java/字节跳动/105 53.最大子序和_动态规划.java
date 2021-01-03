/*
	算法思想：
		简单的dp

*/

class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        }

        int max = dp[0];
        for(int num:dp)
            max = Math.max(num,max);
        return max;
    }
}
/*
	算法思想：
		动态规划，第三次看到了，还是忘记了。。。。。（以为是滑动窗口）
*/
 

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length<=0) return 0;
        //dp[i]：以数组nums[i]为结尾的最大数组和。
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for(int i=1;i<nums.length;i++){
            //状态转移，dp[i]要么是当前数组，要么是dp[i-1]+nums[i]
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}












/*
	算法思想：
		动态规划
		
		由于不要连续，因此我们要确定一个数字位置后，再判断这个数之前的数，是否严格小于当前的固定数！，如果小于，则进行状态转移
		状态转移方程为dp[i] = Math.max(dp[j]+1,dp[i]);
		
		
题解：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/dong-tai-gui-hua-er-fen-cha-zhao-tan-xin-suan-fa-p/
*/


class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);

        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[j]+1,dp[i]);
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
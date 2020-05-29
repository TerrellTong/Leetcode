/*
	算法思想：
		动态规划
	
	与之前的招待客人思想类似
	转移方程：偷：dp[i-2]+nums[i]（由于不能同时连续偷两家，因此这个状态一定从dp[i-2]+nums[i]过来的）
            不偷：从dp[i-1]过来的
		
*/
 
class Solution {
    public int rob(int[] nums) {
        //特殊情况
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            //偷：dp[i-2]+nums[i]（由于不能同时连续偷两家，因此这个状态一定从dp[i-2]+nums[i]过来的）
            //不偷：从dp[i-1]过来的
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[nums.length-1];
    }
}









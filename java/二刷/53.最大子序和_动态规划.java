/*
	算法思想：
		动态规划
				
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int size = nums.length;
       int[] dp = new int [size];
        dp[0] = nums[0];
		//因为只有一层for循环，状态转移方程不能写max(dp[i],dp[i-1]+nums[i])只能写max(nums[i],dp[i-1]+nums[i])
       for(int i=1;i<size;i++){
           dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
       }
       int max = dp[0];
       for(int i=0;i<size;i++){
           if(max < dp[i]){
               max = dp[i];
           }
       }
       return max;
    }
}












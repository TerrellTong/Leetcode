 /*
	算法思想：
	动态规划
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0)
            return 0;

        //动态规划
        int[] dp = new int[nums.length];
        int max = 0;
        //把dp数组全部置为1
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
        }
        //从dp数组中找到最大值
         for(int i=0;i<nums.length;i++){
             if(max < dp[i])
                max = dp[i];
         }
         return max+1;
    }
}


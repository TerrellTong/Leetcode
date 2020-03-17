 /*
	算法思想：
	动态规划
 */
class Solution {
    public int findNumberOfLIS(int[] nums) {
     int[] count = new int [nums.length];
        int[] dp = new int [nums.length];
        //用1填充数组
        Arrays.fill(count,1);
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
					//这个是max函数的表达形式，需要在这个过程中进行计数判断
                    if(dp[i] <= dp[j]){
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }else if(dp[i] == dp[j] + 1){
                        count[i] = count[i] + count[j];
                    }
                    }
                }

            }

        int max = 0;
        for(int i=0;i<dp.length;i++){
            if(max < dp[i])
                max = dp[i];
        }

        int result = 0;
        for(int i = 0; i <dp.length; i++){
            if(max == dp[i]){
                result += count[i];
            }
        }
        return result;
}
}


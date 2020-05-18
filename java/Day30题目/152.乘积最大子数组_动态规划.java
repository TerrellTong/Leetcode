/*
	算法思想：
		动态规划，与53的状态转移方程进行区别，这题要考虑负数的情况
		由于找到的是连续的，因此转移方程是max(nums[i],dp[i-1]*nums[i])，如果是max(dp[i-1],dp[i-1]*nums[i])找到的是最大数值
*/
 

class Solution {
  public int maxProduct(int[] nums) {
    int prevMin = nums[0], prevMax = nums[0], res = nums[0];
    int temp1 = 0, temp2 = 0;
    //此时不能直接用dp[j]=dp[j−1]∗nums[j] 状态转移方程，因为如果存在两个负数，则负负得正，即（-2,3，-4）
    /*
    ●我们把dp[j- 1]直接拿过来相乘,结果肯定是最好的吗?
    ●我们忽略了j项可以是负数,如果是负数，则dp[j- 1]最大积的话,得到dp[j]会是最小的。此时j - 1的最优
    解应是负数的最大，即最小乘积
    ●如果j项是正数，才应该把之前的最大积直接拿来乘
    ●即,对j来说，j- 1的最优解可能是最大乘积，也可能是最小乘积
    ●因此，我们要维护一个局部最大值， 还要维护一个局部最小值
    j是负数，则乘以最小乘积，j是正数，则乘以最大乘积
    */
    for (int i = 1; i < nums.length; i++) {
      temp1 = nums[i] * prevMax;
      temp2 = nums[i] * prevMin;
      prevMax = Math.max(Math.max(temp1, temp2), nums[i]);
      prevMin = Math.min(Math.min(temp1, temp2), nums[i]);
      res = Math.max(res, prevMax);
    }
    return res;
  }
}













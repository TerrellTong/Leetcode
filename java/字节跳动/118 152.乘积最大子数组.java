/*
	算法思想：
		动态规划，由于存在负负得正，因此我们要用两个dp数组，记住最大，可能下一次的最大就是由当前的负数*之前的最小得到的！
		
	题解：https://leetcode-cn.com/problems/maximum-product-subarray/solution/cheng-ji-zui-da-zi-shu-zu-by-leetcode-solution/  之前做过，还是错了！
	
*/


class Solution {
    public int maxProduct(int[] nums) {
        //由于存在负负得正，因此我们要用两个dp数组
        int[] maxF = new int[nums.length];
        int[] minF = new int[nums.length];

        maxF[0] = nums[0];
        minF[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            maxF[i] = Math.max(Math.max(maxF[i-1]*nums[i],nums[i]),Math.max(minF[i-1]*nums[i],nums[i]));
            minF[i] = Math.min(Math.min(maxF[i-1]*nums[i],nums[i]),Math.min(minF[i-1]*nums[i],nums[i]));
        }

        int max = maxF[0];
        for(int d:maxF){
            max = Math.max(max,d);
        }
        return max;
    }
}
/*
	算法思想：
		滑动窗口的思想
*/


class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int res = 0;
        int count = 0;
        double avg = Integer.MIN_VALUE;
        while(right<nums.length){
            res += nums[right];
            right++;
            count++;

            //窗口收缩
            while(count == k){
                count--;
                avg = Math.max(res/Double.valueOf(k),avg);
                res -= nums[left];
                left++;
            }
        }
        return avg;
    }
}
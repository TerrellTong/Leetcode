/*
	算法思想：
		滑动窗口:  不需要进行数组排序！！！（不需要数组大小是从小到大进行有序排列的！！！）
			right：表示滑动窗口的右窗口的下一个位置！！！
			left: 表示滑动窗口的左窗口
			因此，right应该小于等于nums.length,并需要判断出界的条件
*/
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int len = nums.length;
        boolean flag = false;
        while (right <= nums.length) {
            if (sum < s) {
                if(right == nums.length)
                    break;
                sum += nums[right];
                right++;
            } else if (sum >= s){
                flag = true;
                len = Math.min(right - left, len);
                sum -= nums[left];
                left++;
                }
            }
        
        return flag ? len:0;
    }
}
    






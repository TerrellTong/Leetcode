/*
	算法思想：
		按照二分的思想，题解的方法三！
	
	题解思想：https://leetcode-cn.com/problems/find-peak-element/solution/xun-zhao-feng-zhi-by-leetcode/
*/


//O(1)
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 2){
            return nums[0] > nums[1] ? 0 : 1;
        }
        int end = 0;
        for(int i=1;i<nums.length-1;i++){
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1])
                return i;
            else if(nums[i] > nums[i-1])
                end++;

        }
        return end == nums.length-2 ? end+1 : 0;
    }
}

//二分的思路
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
		//不能取等于，因为取等于会出现死循环
        while(left < right){
            int mid = (left + right) >>> 1;
            //此时要么在右下坡，要么在峰顶
            if(nums[mid] > nums[mid+1])
                right = mid;
            else
                left = mid+1;
        }
        return left;
    }
}
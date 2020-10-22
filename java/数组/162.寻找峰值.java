/*
	算法思想：
		二分查找，当mid，大于左边且大于右边，直接返回，否则就移动left或者right，注意特殊情况
		
*/

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1)
            return 0;

        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = (left + right) >>> 1;
            int left_value,right_value;
            if(mid == 0){
                left_value = Integer.MIN_VALUE;
                right_value = nums[mid+1];
            }else if(mid == nums.length-1){

                left_value = nums[mid-1];
                right_value = Integer.MIN_VALUE;
            }else{
                left_value = nums[mid-1];
                right_value = nums[mid+1];
            }

            if(left_value < nums[mid] && nums[mid] > right_value)
                return mid;
            if(nums[mid] < right_value)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return 0;
    }
}

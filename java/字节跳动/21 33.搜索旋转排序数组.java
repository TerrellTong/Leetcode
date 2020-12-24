/*
	算法思想：
		二分查找，注意这个与剑指Offer6，旋转数组的最小值区分（对无序进行选择）！！
*/

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = (left + right)>>>1;
            if(target == nums[mid])
                return mid;

            //此时说明左边有序，右边无序，说明是在右边出现了旋转
            if(nums[mid] <= nums[right]){
                if(target <= nums[right] && nums[mid] <= target)
                    left = mid+1;
                else
                    right = mid-1;
            }else{
                //说明右边有序，左边无序，旋转点在左边
                //如果target
                if(target >= nums[left] && nums[mid] >= target)
                    right = mid-1;
                else
                    left = mid+1;
            }
        }
        return -1;
    }
}
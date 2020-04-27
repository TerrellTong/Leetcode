/*
	算法思想：
		二分查找的思想
*/


class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
		//二分查找是left <= right  快排是left < right
        while(left <= right){
            int mid = left+(right - left)/2;
            if(nums[mid] == target)
                return mid;
            //说明mid的左区间是连续的
            if(nums[left] <= nums[mid]){
                    //如果target在左区间之间，则变right
                	if(nums[left] <= target && target <= nums[mid]){
				        right = mid - 1; // 在左侧 [left,mid) 查找
			        } else {
				        left = mid + 1;
			}
            }else{
                //target在右区间，则改left
                if(nums[mid] <= target && target <= nums[right]) {
				    left = mid + 1; // 在右侧 (mid,right] 查找
			    } else {
				    right = mid - 1;
			    }
            }
        }
        return -1;
    }
}













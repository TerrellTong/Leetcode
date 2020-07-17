/*
	算法思想：
		二分查找，二刷！知道了思路，但是返回值出现了问题。。
*/
class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = (start+end) >>> 1;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target){
                end = mid - 1;
            }else  
                start = mid + 1;
        }
        return start;
    }
}






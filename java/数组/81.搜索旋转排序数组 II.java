/*
	算法思想：
		与搜索旋转排序数组类似，主要是多了一个去重的步骤
		
题解：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/solution/zai-javazhong-ji-bai-liao-100de-yong-hu-by-reedfan/
*/

class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while(left<=right){
            int mid = (left + right) >>> 1;
            if(nums[mid] == target)
                return true;

            //去重
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }
            
            //说明mid的左半边是有序的
            if(nums[left] < nums[mid]){
                
                if(nums[left] <= target && target <= nums[mid])
                    right = mid-1;
                else
                    //如果不满足上面的条件，说明旋转点是在
                    left = mid+1;
            }else{
                if(nums[mid] <= target && target <= nums[right])
                    left = mid+1;
                else
                    right = mid-1;
            }
        }
        return false;
    }
}

/*
	算法思想：
		自己写过，相当于二刷，做了出来，但是复杂度比较高！！！
		找到位置后，直接移动！！

题解：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/javaer-fen-fa-gai-zao-3chong-fang-shi-du-ji-bai-li/
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 1)
            return nums[0] == target ? new int[]{0,0} : new int[]{-1,-1};
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = (left+right)>>>1;
            if(nums[mid] == target){
                int start = mid;
                int end = mid;
                //看看前面是否存在target
                //直接移动！！
                while(start >= 0 && nums[start] == target)
                    start--;
                while(end < nums.length && nums[end] == target)
                    end++; 
                return new int[]{start+1,end-1};
            }else if(nums[mid] < target)
                left = mid+1;
            else
                right = mid-1;
        }
        return new int[]{-1,-1};
    }
}
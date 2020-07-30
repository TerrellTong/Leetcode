/*
	算法思想：
		二分查找，以找旋转数组的旋转点类似，只是多了一个确定target也在递减区间的判断步骤
		二刷时知道大致思路，但是我只将mid-1,mid,mid+1进行比较从而进行判断
	
*/

class Solution {
    public int search(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while(left <= right){
            int mid = (left + right) >>> 1;
            if(nums[mid] == target)
                return mid;
            //先判断mid是在哪个区间
            //说明mid在旋转点的左区间
            if(nums[mid] > nums[right]){
                //确保target是在left和mid的所在区间
                if(nums[left]<= target && target <= nums[mid])
                    right = mid - 1;
                else
                    left = mid+1;
            }else{
                if(target >= nums[mid] && target <= nums[right])
                    left = mid+1;
                else
                    right = mid-1;
            }

        }
        return -1;
    }
}
/*
	算法思想：
		153，二分查找，在数组进行旋转后，若 nums[left] <= nums[mid]，说明区间 [left,mid] 连续递增，则最小元素一定不在这个区间里，可以直接排除。
		因此，令 left = mid+1，在 [mid+1,right] 继续查找。
		否则，说明区间 [left,mid] 不连续，则最小元素一定在这个区间里。因此，令 right = mid，在 [left,mid] 继续查找，注意 right 更新时会被设为 mid 而不是 mid-1，因为 mid 无法被排除。
		这一点和「33 题 查找特定元素」是不同的
		
题解：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/yi-wen-jie-jue-4-dao-sou-suo-xuan-zhuan-pai-xu-s-3/
		

*/

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            //如果最左边的值小于等于最右边的值，那么说明整个数组是递增的，只需要返回最左边即可
            if(nums[left] <= nums[right])
                return nums[left];

            int mid = (left + right) >>> 1;

            //说明左区间有序
            if(nums[left] <= nums[mid]){
                left = mid+1;
            }else{
                //此时说明左区间不是有序的，那么最小值一定会在其中，但是并不能排除mid是否就为最小值，因此right = mid!
                right = mid;
            }
        }
        return nums[left];
    }
}


/*
	算法思想：
		快速排序
				
*/

class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }
    //分出partition，将一边分为小于partition的，一边分为大于partition的
    public int partition(int[] nums, int left, int right) {
        int tmp = nums[left];
        while (left < right) {
            //如果右边的值大于中轴，则右指针左移
            while(left<right&&nums[right]>=tmp)
                right--;
            //如果出现右边的值小于中轴，则和左边互换，同时左边指针+1
            if (left < right) {
                nums[left] = nums[right];
                left++;
            }
            //同上
            while(left<right&&nums[left]<=tmp)
                left++;
            if(left<right){
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = tmp;
        return left;
    }
    public  void quickSort(int[] nums, int left, int right) {
        if(left>=right||nums.length<=1)
            return;
        int mid = partition(nums, left, right);
        quickSort(nums,left,mid-1);
        quickSort(nums, mid + 1, right);
    }
}









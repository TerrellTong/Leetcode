/*
	算法思想：
		与寻找旋转数组的最小值类似，只是对于重复元素的处理有了不同
		
		（一） 一种是直接遍历 [left,right] 每一项
		（二） 另一种是 left++，跳过一个干扰项
		
	此时只能用一，因为如果最小值为left，则left++会被略过，因此只能用第一种方式
		

*/

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = (left + right) >>> 1;
            if(nums[left] < nums[right])
                return nums[left];
            //不能使用，因为如果left为最小值，则会被跳过
            if(nums[left] == nums[mid]){
                int min = nums[left];
                for(int i=left;i<=right;i++){
                    min = Math.min(nums[i],min);
                }
                return min;
            }

            
            if(nums[left] < nums[mid]){
                left = mid + 1;
            }else
                right = mid;
        }
        return nums[left];
    }
}

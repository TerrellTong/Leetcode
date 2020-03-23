/*
	算法思想：
		快指针快速的向前遍历，如果出现了与慢指针不同的数，则将慢指针前进一位，然后用快指针的值覆盖慢指针的值。否则快指针就一直往前走
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0)
            return 0;
		//i是慢指针,j是快指针
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
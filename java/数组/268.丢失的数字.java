/*
	算法思想：
		我用的记住前一个数字，判断它与前一个值是否差1
		还可以用高斯求和公式进行判断！

*/

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        
        Arrays.sort(nums);
        int pre = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]-1 != pre)
                return pre+1;
            pre = nums[i];
        }
        //说明丢失的数字为两端
        return nums[n-1] == n ? 0 : n;
    }
}
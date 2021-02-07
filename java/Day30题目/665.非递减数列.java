/*
	算法思想：
		我是按照之前的pre进行比较，没有修改原数组，但是comment的方法是修改了nums数组
		对于修改数字，有一个规律
		4，2，3
		-1，4，2，3
		2，3，3，2，4
		首先如果再前面的数不存在，比如例子1，4前面没有数字了，我们直接修改前面的数字为当前的数字2即可。
		而当再前面的数字存在，并且小于当前数时，比如例子2，-1小于2，我们还是需要修改前面的数字4为当前数字2；
		如果再前面的数大于当前数，比如例子3，3大于2，我们需要修改当前数2为前面的数3。
		
题解：https://leetcode-cn.com/problems/non-decreasing-array/comments/
*/


class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length <= 1) {
		    return true;
	    }
        int cnt = 0;
        for(int i=1;i<nums.length && cnt < 2;i++){
            //如果前面小于等于后面则continue
            if(nums[i-1] <= nums[i])
                continue;
            cnt++;
			//再前面的数大于当前数。则把当前数修改为前一个数
            if(i-2 >= 0 &&nums[i-2] > nums[i])
                nums[i] = nums[i-1];
            else
				//再前面的数小于当前数。则当前数不修改，把前一个数修改为当前数
                nums[i-1] = nums[i];
        }
        return cnt <= 1;
    }
}
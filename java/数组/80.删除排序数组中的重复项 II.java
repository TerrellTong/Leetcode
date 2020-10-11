/*
	算法思想：
		记录次数， 另外用一个指针j，记录真正的位置，直接覆盖原数组！！
		
思路：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-xiang-i-7/ 方法2
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        int count = 1;
        int tmp = nums[0];
        //表示真正数组长度大小
        int j = 1;
        //投票选举
        for(int i=1;i<nums.length;i++){
            if(tmp == nums[i])
                count++;
            else{
                tmp = nums[i];
                count = 1;
            }
            //如果次数小于等于2，则把nums[i]的值赋给nums[j]，并且j++
            if(count <= 2)
                nums[j++] = nums[i];
        }

        return j;
    }
}

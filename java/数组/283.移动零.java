/*
	算法思想：
		我的思想：先排序，在找到起始的0，终止的0，然后将后面的移动
		
		题解：数组原地移动的思想！！直接放一个指针在前面，满足条件就通过交换放到前面，然后指针右移，之前做过！！！没记住！！

*/

class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        
        int p = 0;
        int len = nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                int tmp = nums[i];
                nums[i] = nums[p];
                nums[p++] = tmp;
            }
        }
    }
}
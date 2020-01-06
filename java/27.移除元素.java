/*
	算法思想：
		(快指针从0开始)
		快指针进行循环遍历，如果出现了与给定的val值不同，则将快指针的值赋给慢指针的值，然后用快指针慢指针一起往前走。否则快指针就一直往前走
*/

class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
    }
    return i;
    }
}
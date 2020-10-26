/*
	算法思想：
		先排序，然后判断count
*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length == 0)
            return false;
        Arrays.sort(nums);
        int count = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1])
                count++;
            else
                count = 1;
            if(count >= 2)
                return true;
        }
        return false;
    }
}

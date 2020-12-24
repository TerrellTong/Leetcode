/*
	算法思想：
		Map，两数之和
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            int sub = target - nums[i];
            if(map.containsKey(sub))
                return new int[]{map.get(sub),i};
            else
                map.put(nums[i],i);
        }
        return new int[]{};
    }
}
/*
	算法思想：
		通过放入HashMap即可
*/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0;i<nums.length;i++){
            if(map.get(nums[i]) == null){
                map.put(nums[i],i);
            }else{
                int preIndex = map.get(nums[i]);
                if(Math.abs(i-preIndex) <= k)
                    return true;
                map.put(nums[i],i);
            }
        }
        return false;
    }
}

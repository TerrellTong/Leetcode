/*
	算法思想：
		哈希表
*/
class Solution {
    public int firstMissingPositive(int[] nums) {
        Map<Integer,Boolean> map  = new HashMap();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],true);
        }
        int i=1;
        while(true){
            if(map.containsKey(i))
                i++;
            else
                return i;
        }
    }
}





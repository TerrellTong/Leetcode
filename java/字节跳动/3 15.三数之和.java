/*
	算法思想：
		固定最左边，然后考虑右边两个，注意去重！！！
		

*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();
        for(int i=0;i<nums.length;i++){
            //剪枝，判断什么时候提前退出
            if(nums[i] > 0)
                break;
            //去重
            if(i>0 && nums[i] == nums[i-1])
                continue;
            int cur = nums[i];
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                int sum = cur + nums[left] + nums[right];
                if(sum > 0)
                    right--;
                else if(sum < 0){
                    left++;
                }else{
                    res.add(Arrays.asList(cur,nums[left],nums[right]));
                    //去重
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
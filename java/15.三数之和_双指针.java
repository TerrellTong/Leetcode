/*
	算法思想：
		排序+双指针，两数之和的变体，我两数之和用的Hash做的
*/
 
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        int len = nums.length;
        if(nums == null || len<3)
            return res;
        //排序，方便后面的双指针移动
        Arrays.sort(nums);
        
        for(int i=0;i<len;i++){
            //由于数组已经进行了排序，如果当前数字大于0，说明三数之和一定大于0，不满足条件
            if(nums[i] > 0)
                break;
            //去重
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int L = i+1;
            int R = len-1;
            //左右指针移动
            while(L<R){
                int sum = nums[i]+nums[L]+nums[R];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while(L<R && nums[L] == nums[L+1]) L++; //去重
                    while(L<R && nums[R] == nums[R-1]) R--; //去重
                    L++;
                    R--;
                }
                //相当于滑动窗口，如果<0,则L移动，否则R移动
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return res;
    }
}












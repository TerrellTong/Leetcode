/*
	算法思想：
		双指针+排序，二刷还是不会。。。
		固定一个点，然后双指针判断和
	
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        //对数组进行排序
        Arrays.sort(nums);
        int len = nums.length;
        for(int i=0;i<len;i++){
            //由于数组进行了排序，因此，以nums[i]为起始进行计算的结果一定大于0
            if(nums[i] > 0)
                break;
            //去重
            if(i>0 && nums[i] == nums[i-1])
                continue;
            //以nums[i]为起点，L=nums[i]+1,R=len-1;从而计算三数之和
            int L = i+1;
            int R = len-1;
            while(L<R){
                int sum = nums[i]+nums[L]+nums[R];
                if(sum > 0)
                    R--;
                else if(sum < 0)
                    L++;
                else{
                    res.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    //添加满足了等于0的条件后，L,R都进行相应的移动
                    while(L<R && nums[L]== nums[L+1]) L++;//去重
                    while(L<R && nums[R] == nums[R-1]) R--;//去重
                    L++;
                    R--;
                }
                    
            }
        }
        return res;
    }
}




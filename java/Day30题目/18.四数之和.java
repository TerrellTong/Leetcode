/*
	算法思想：
		四数之和，将sum-其中的一个数字，然后就转换成了三数之和！
		
		回溯会超时！！
		
*/


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList();

        int len = nums.length;
        if(nums == null || len < 4)
            return ans;

        Arrays.sort(nums);

        for(int i=0;i<len-3;i++){
            //去掉重复情况
            if(i > 0 && nums[i] == nums[i-1])
                continue;

            int k = i+1;
            for(int j=k;j< len-2;j++){//第二层起始点在第一层基础上+1，终止在len-2
                //去掉重复情况
                if(j > k && nums[j] == nums[j-1])
                    continue;

                int sum = target - nums[i]; //和用target减去第一层的值

                int L = j+1;
                int R = len-1;

                //进行三数循环的操作
                while(L < R){
                    int res = nums[j] + nums[L] + nums[R];
                    if(res == sum){
                        ans.add(new ArrayList(Arrays.asList(nums[i],nums[j],nums[L],nums[R])));
                        L++;
                        R--;
                        //去重
                        while(L < R && nums[L] == nums[L-1])
                            L++;
                        while(L < R && nums[R] == nums[R+1])
                            R--;
                    }else if(res < sum)
                        L++;
                    else
                        R--;
                }
            }
        }
        return ans;
    }
}
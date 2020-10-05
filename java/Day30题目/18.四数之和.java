/*
	算法思想：
		上周做过此题，还是出现了同样的问题！！！
		else if的>，< 还是忘记写了！！！
		去重考虑到了，不知道怎么书写！！
*/


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList();
        int len = nums.length;

        Arrays.sort(nums);
        
        //第一层
        for(int i=0;i<len-3;i++){
            //去重
            if(i > 0 && nums[i] == nums[i-1])
                continue;

            //按照三数之和的思路
            for(int j=i+1;j<len-2;j++){
                //去重
                if(j > i+1 && nums[j] == nums[j-1])
                    continue;

                int L = j+1;
                int R = len-1;
                while(L < R){
                    int sum = nums[j] + nums[L] + nums[R];
                    if(sum == target-nums[i]){
                        res.add(Arrays.asList(new Integer[]{nums[i],nums[j],nums[L],nums[R]}));
                        L++;
                        R--;
                        //去重
                        while(L < R && nums[L] == nums[L-1])
                            L++;
                        while(L < R && nums[R] == nums[R+1])
                            R--;
                    }else if(sum > target-nums[i])
                        R--;
                    else 
                        L++;
                    
                }
            }
        }

        return res;
    }
}
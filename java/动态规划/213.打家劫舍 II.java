/*
	算法思想：
		记忆化搜索
		由于出现了环，因此只能分成两个部分考虑，0，length-1.. 和1，length
题解：

*/

class Solution {
    int[] memo1;
    int[] memo2;
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        memo1 = new int[nums.length];
        memo2 = new int[nums.length];
        Arrays.fill(memo1,-1);
        Arrays.fill(memo2,-1);
        //由于出现了环，因此只能分成两个部分考虑，0，length-1 .. 和1，length
        //需要声明两个不同的memo，防止因为共用一个memo而出错
        return Math.max(tryRob(nums,0,nums.length-1,memo1),tryRob(nums,1,nums.length,memo2));
    }

    public int tryRob(int[] nums,int pos,int end,int[] memo){
        if(pos >= end)
            return 0;
        
        if(memo[pos] != -1){
            return memo[pos];
        }

        int res = 0;
        for(int i=pos;i<end;i++){
            res = Math.max(res,nums[i]+tryRob(nums,i+2,end,memo));
        }
        memo[pos] = res;
        return memo[pos];
    }
}
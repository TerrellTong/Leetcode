/*
	算法思想：
		左，右后缀积
	
*/
 
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];

        //用ans数组暂存，L数组
        ans[0] = 1;
        //用ans代替存储L乘积
        for(int i=1;i<nums.length;i++)
            ans[i] = ans[i-1] * nums[i-1];
        
		//由于R表示后缀积，且最后面的元素的后缀积为1 
		//后缀积i = 后一个后缀积i+1 * nums[i+11]
        int R=1;
        //左乘积和右乘积
        for(int i=nums.length-1;i>=0;i--){
            ans[i] = ans[i] * R;
			//更新右乘积
            R *= nums[i];
        }
            
        return ans;
    }
}










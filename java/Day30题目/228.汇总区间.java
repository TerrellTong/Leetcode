/*
	算法思想：
		多次翻转，首先整个数组进行翻转，然后从0开始到取余的位置进行翻转，最后对取余后的位置进行翻转
		二刷，之前是用链式反应，不会做！！！
		
		
题解：https://leetcode-cn.com/problems/rotate-array/solution/javadai-ma-3chong-fang-shi-tu-wen-xiang-q8lz9/ ，方法二
*/



class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length == 0)
            return new ArrayList();

        List<String> res = new ArrayList();
        int left = nums[0];
        int pre = left;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-1 == pre){
                pre = nums[i];
            }else{
                if(left == pre)
                    res.add(left+"");
                else
                    res.add(left+"->"+pre);
                left = nums[i];
                pre = left;
            }
        }
        if(left == pre)
            res.add(left+"");
        else{
            res.add(left+"->"+pre);
        }
        return res;
    }
}
/*
	算法思想：
		知道算法思想，但是自己写复杂了！！用了while，left，right，tmp
		直接判断j即可！！！
*/

class Solution {
    public List<String> summaryRanges(int[] nums) {
        int left = 0, right = 1;
        List<String> res = new ArrayList();

        //如果左边和右边不差1，则一直查找
        for(int i=0,j=0;j<nums.length;j++){
            //只用j进行判断
            if(j+1 < nums.length && nums[j+1] == nums[j] + 1)
                continue;
            //此时nums[j] +1 != nums[j+1] 说明不是一个区间
            if(i == j)
                res.add(nums[i]+"");
            else
                res.add(nums[i]+"->"+nums[j]);
            i = j+1;
        }
        return res;
    }
}
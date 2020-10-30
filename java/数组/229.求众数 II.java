/*
	算法思想：
		摩尔投票，升级版
		如果至多选一个代表，那他的票数至少要超过一半（⌊ 1/2 ⌋）的票数；

		如果至多选两个代表，那他们的票数至少要超过 ⌊ 1/3 ⌋ 的票数；

		如果至多选m个代表，那他们的票数至少要超过 ⌊ 1/(m+1) ⌋ 的票数。

作者：wotxdx
链接：https://leetcode-cn.com/problems/majority-element-ii/solution/liang-fu-dong-hua-yan-shi-mo-er-tou-piao-fa-zui-zh/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //创建返回值
        List<Integer> res = new ArrayList();
        if(nums == null || nums.length == 0)
            return res;
        //初始化两个候选人，和他们的计票
        int cand1 = nums[0],count1 = 0;
        int cand2 = nums[0],count2 = 0;

        //摩尔投票，配对阶段和计数阶段
        //配对
        for(int num:nums){
            //投票
            if(cand1 == num){
                count1++;
                continue;
            }
            if(cand2 == num){
                count2++;
                continue;
            }

            //第一个候选人被换
            if(count1 == 0){
                cand1 = num;
                count1++;
                continue;
            }
            if(count2 == 0){
                cand2 = num;
                count2++;
                continue;
            }

            count1--;
            count2--;
        }

        //重新计票
        //上一轮遍历找出了两个候选人，但是两个候选人是否均满足条件N/3无法确定，需要重新遍历
        count1 = 0;
        count2 = 0;
        for(int num:nums){
            if(num == cand1)
                count1++;
            else if(num == cand2)
                count2++;
        }

        if(count1 > nums.length/3)
            res.add(cand1);
        if(count2 > nums.length/3)
            res.add(cand2);
        
        return res;
    }
}
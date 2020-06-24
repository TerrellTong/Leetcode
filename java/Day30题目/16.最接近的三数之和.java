/*
	算法思想：
		与15.三数相加的思路类似，只是加了一个进行距离判断
		自己做成功了80多个，但是当target为负数则出现了问题，自己直接用的nums[0] + nums[1] + nums[2] - target作为的距离
		而答案用的是target-nums[0] + nums[1] + nums[2] ，而且R,L要根据sum与target的大小关系进行相应的指针移动
*/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //排序
        Arrays.sort(nums);
        //让其三项和作为参照对象
        //不用前三项和与target的差值作为参照对象，因为有可能target为负数
        int ans = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length;i++){
            //不需要在此判断nums[i]是否大于target，因为题目找最接近的，有可能后面的也满足条件
            // if(nums[i] >= target)
            //     break;
            int L=i+1;
            int R=nums.length-1;
            while(L<R){
                int sum = nums[i]+nums[L]+nums[R];
                //如果target与sum的差值绝对值小于target与ans的差值
                //则ans进行替换，ans用来存储最短距离
                if(Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if(sum > target)
                    R--;
                else if(sum < target)
                    L++;
                else
                    return ans;
            }
        }
        return ans;
    }
}





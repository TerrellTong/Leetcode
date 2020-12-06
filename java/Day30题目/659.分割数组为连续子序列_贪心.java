/*
	算法思想：
		定义两个hashmap,一个HashMap用于存储这个数字出现的次数，一个用于存储结尾
		如果某个数字没有用完，而且其前一个数字的tail还大于0，则可以将这个数字拼到当前数字
		/如果某连续的三个数字存在，则我们直接取出来，进行拼装
		反之，在次数用完时，直接看下一个数字
		数字出现的多了，直接返回false



题解：https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/solution/tan-xin-suan-fa-jian-cha-shu-zu-neng-fou-bei-fen-w/
*/

class Solution {
    public boolean isPossible(int[] nums) {
        //count用来存储每个数字出现的次数
        Map<Integer,Integer> countNum = new HashMap();
        for(int num:nums){
            countNum.put(num,countNum.getOrDefault(num,0)+1);
        }

        Map<Integer,Integer> tail = new HashMap();
        for(int num:nums){
            //获取当前数字的次数
            int count = countNum.getOrDefault(num,0);
            //如果当前数字的次数为0，则不用管，继续下一步
            if(count <= 0)
                continue;
            else if(tail.getOrDefault(num-1,0) > 0){ //说明当前数字没有用完，可以放到tail尾部
                countNum.put(num,count-1);
                tail.put(num-1,tail.get(num-1)-1); //覆盖当前的最长子序列
                tail.put(num,tail.getOrDefault(num,0)+1);//将当前位置的尾部序列+1
            }else if(countNum.getOrDefault(num+1,0) > 0 && countNum.getOrDefault(num+2,0) > 0){//判断是否后面两个都大于0，形成一个子序列
                countNum.put(num,count-1);
                countNum.put(num+1,countNum.get(num+1)-1);
                countNum.put(num+2,countNum.get(num+2)-1);
                tail.put(num+2,tail.getOrDefault(num+2,0)+1);//当前以num+2结尾的子序列+1
            }else   
                return false;
        }
        return true;

    }
}
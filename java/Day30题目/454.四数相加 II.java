/*
	算法思想：
		先把A，B两个元组中各个元素和相加，放入到map中，然后判断C,D元素和的相反数 是否在A,B存在map中

题解：https://leetcode-cn.com/problems/4sum-ii/solution/chao-ji-rong-yi-li-jie-de-fang-fa-si-shu-xiang-jia/
*/

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map = new HashMap();
        int res = 0;
        //计算A+B 各个元素的和
        for(int i=0;i<A.length;i++)
            for(int j=0;j<B.length;j++){
                int sumAB = A[i] + B[j];
                int count = map.getOrDefault(sumAB,0);
                count++;
                map.put(sumAB,count);
            }
        
        //计算C+D的和，判断是否存在相反数！
        for(int i=0;i<C.length;i++)
            for(int j=0;j<D.length;j++){
                int sumCD = -(C[i]+D[j]);
                if(map.containsKey(sumCD))
                    res += map.get(sumCD);
            }

        return res;
    }
}
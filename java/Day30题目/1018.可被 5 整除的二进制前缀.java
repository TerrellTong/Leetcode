/*
	算法思想：
		每个pre左移移位，然后+A[i],进行%5，然后判断是否能余5
*/



class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        if(A.length == 0)
            return new ArrayList();

        List<Boolean> res = new ArrayList();
        int pre = 0;
        for(int i=0;i<A.length;i++){
            pre = ((pre<<1 )+ A[i])%5;
            res.add(pre == 0);
        }

        return res;
    }
}
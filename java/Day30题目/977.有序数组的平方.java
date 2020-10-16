/*
	算法思想：
		
		

*/

class Solution {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int index = 0;
        for(int num:A){
            int tmp = num*num;
            res[index++] = tmp;
        }
        Arrays.sort(res);
        return res;
    }
}

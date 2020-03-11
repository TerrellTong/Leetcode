 /*
	算法思想：
	直接暴力，不需要用滑动窗口，因为滑动窗口会出现前四个和为10而前两个的和又大于10，则就不满足

 */
class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        //计算总和
        int sum = 0;
        //存放数组的list
        List<int[]> res  = new ArrayList<>();
        for(int i=0;i<A.length;i++){
            sum  =  sum + A[i];
        }
        if(sum % 3 == 0){
        int s = 0;
        int flag = 0;
        for(int i:A){
            s += i;
            if(s == sum/3){
                flag++;
                s = 0;
            }
        }
        // flag不一定等于3，例如[1,-1,1,-1,1,-1,1,-1]
            return flag >= 3;

        }else
            return false;
    }
}

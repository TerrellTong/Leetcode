/*
	算法思想：
		二分查找

*/

public class Solution extends GuessGame {
    public int guessNumber(int n) {
       int start = 1;
       int end = n;
       //二分查找的循环条件
        while(start <= end){
           //不能直接用（start+end）/2，因为有可能会出现溢出现象
           int middle = (start+end)>>>1;  // 或者写成start + (end - start) /2
           int result = guess(middle);
           if(result > 0)
               start = middle+1;
            else if(result < 0 )
                end = middle-1;
            else  if(result == 0)
            return middle; 
        }
        return -1;
    }
}

















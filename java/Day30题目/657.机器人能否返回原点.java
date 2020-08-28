/*
	算法思想：
		比较简单，直接模拟即可
		
*/


class Solution {
    int[] step = {1,-1,-1,1};
    public boolean judgeCircle(String moves) {
        int[][] start = new int[1][2];
        start[0][0] = 0;
        start[0][1] = 0;
        for(int i=0;i<moves.length();i++){
            char c = moves.charAt(i);
            if(c == 'R')
                start[0][1] += step[0];
            else if(c == 'L')
                start[0][1] += step[1];
            else if(c == 'U')
                start[0][0] += step[2];
            else if(c == 'D')
                start[0][0] += step[3];
        }
        if(start[0][0] == 0 && start[0][1] == 0)
            return true;
        return false;

    }
}
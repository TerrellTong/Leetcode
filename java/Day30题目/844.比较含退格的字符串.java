/*
	算法思想：
		倒着想！！
		当正着想不通的时候，尝试的倒着想！！
		遇到#，则继续循环！
		

*/

class Solution {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder SS = new StringBuilder();
        StringBuilder TT = new StringBuilder();
        //记录退格的数量
        int count = 0;
        //从后往前开始遍历！！
        for(int i=S.length()-1;i>=0;i--){
            if(S.charAt(i) == '#'){
                count++;
                continue;
            }
            if(count > 0){
                count--;
                continue;
            }else{
                SS.append(S.charAt(i));
            }
        }

        //重置count
        count = 0;

        for(int i=T.length()-1;i>=0;i--){
            if(T.charAt(i) == '#'){
                count++;
                continue;
            }
            if(count > 0){
                count--;
                continue;
            }else{
                TT.append(T.charAt(i));
            }
        }

        if(SS.toString().equals(TT.toString()))
            return true;
        return false;
    }
}


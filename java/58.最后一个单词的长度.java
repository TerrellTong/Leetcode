/*
	
*/

class Solution {
    public int lengthOfLastWord(String s) {
        String[] str_arr = s.split(" ");
        //����split�������  
        int length = str_arr.length;
        //������鳤��Ϊ0(�����ַ���)
        if(length == 0)
            return 0;
        int count=0;
        for(;count<str_arr[length-1].length();count++);
        return count;
    }
}

